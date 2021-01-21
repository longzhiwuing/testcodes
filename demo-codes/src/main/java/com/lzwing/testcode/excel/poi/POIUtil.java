package com.lzwing.testcode.excel.poi;


import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static org.apache.poi.ss.usermodel.Cell.*;

public class POIUtil {
    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(POIUtil.class);

    private static ThreadLocal<List<RectangleArea>> mergeAreaList = new ThreadLocal<>();

    public static List<RectangleArea> getMergeAreaList() {
        return mergeAreaList.get();
    }

    public static void setMergeAreaList(List<RectangleArea> list) {
        mergeAreaList.set(list);
    }

    /**
     * 获取单元格的值
     *
     * @param cell
     * @return
     */
    public static String getCellValue(Cell cell) {
        String cellValue = "";
        int cellType = cell.getCellType();
        if (cellType == CELL_TYPE_STRING) {
            cellValue = cell.getStringCellValue();
        } else if (cellType == CELL_TYPE_NUMERIC) {
            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                LOGGER.info("date: {}", cell.getDateCellValue());
                cellValue = String.valueOf(cell.getDateCellValue().getTime());
            } else {
                if (cell instanceof XSSFCell) {
                    cellValue = ((XSSFCell) cell).getRawValue();
                } else {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                }
//                cellValue = String.valueOf(df.format(cell.getNumericCellValue()));
            }
        } else if (cellType == CELL_TYPE_FORMULA) {
            switch (cell.getCachedFormulaResultType()) {
                case CELL_TYPE_NUMERIC:
                    // 保留两位小数
                    cellValue = String.valueOf(new DecimalFormat("#.00").format(cell.getNumericCellValue()));
                    break;
                case CELL_TYPE_STRING:
                    cellValue = String.valueOf(cell.getRichStringCellValue());
                    break;
            }
        } else if (cellType == CELL_TYPE_BLANK) {
            cellValue = cell.getStringCellValue();
        }
        return cellValue;
    }

    /**
     * 读取excel
     * 注意： 默认读取的数据是在第一个sheet中的，暂不支持多个sheet的读取
     *
     * @param ins        输入流
     * @param headRowNum 表头所在行数
     * @return 返回excel中的字符串数据
     * @throws Exception
     */
    public static List<List<String>> readFile(InputStream ins, int headRowNum) throws Exception {
        Workbook workbook = WorkbookFactory.create(ins);
        Sheet sheet = workbook.getSheetAt(0);
        // 获取excel总行数
        int rownum = sheet.getLastRowNum();
        List<List<String>> result = new ArrayList<>();
        LOGGER.info("excel 总行数：{}", rownum);
        // 获取表头那一行的数据长度
        short allColumnNum = sheet.getRow(headRowNum).getLastCellNum();

        for (int i = 0; i <= rownum; i++) {
            Row row = sheet.getRow(i);
            if (row == null || row.getPhysicalNumberOfCells() == 0) {
                LOGGER.info("第{}行数据为空.", i);
                continue;
            }
            List<String> oneRecord = new ArrayList<>();
            for (int j = 0; j < allColumnNum; j++) {
                Cell cell = row.getCell(j);
//                cell.setCellStyle(cellStyle);
                if (cell == null) {
                    oneRecord.add("");
                    continue;
                }
                String cellValue = getCellValue(cell);
                oneRecord.add(cellValue);
            }
            result.add(oneRecord);
        }
        LOGGER.info("读取文件完成!");
        return result;
    }

    /**
     * 将读取到的excel数据存入List<cls>列表中
     *
     * @param list        字符串
     * @param cls         解析的类对象
     * @param parseIndex  开始解析的行数
     * @param excludeAttr 哪些属性不解析
     * @return 对应的对象列表
     * @throws Exception
     */
    public static <T> List<T> getEntityList(List<List<String>> list, Class<T> cls, int parseIndex, String... excludeAttr) throws Exception {
        List<T> result = new ArrayList<>();
        for (int i = parseIndex; i < list.size(); i++) {
            List<String> oneRecord = list.get(i);
            T instance = cls.newInstance();
            for (int j = 0, tmp = 0; j < oneRecord.size(); j++) {
                String cellValue = oneRecord.get(j);
                if (StringUtils.isEmpty(cellValue)) continue;
                Field[] fields = cls.getDeclaredFields();
                Field field = fields[j];
                for (String s : excludeAttr) {
                    if (field.getName().equals(s)) {
                        tmp++;
                        break;
                    }
                }
                field = fields[j + tmp];
                Object cellVal = field.getType().equals(Date.class) ? new Date(Long.parseLong(cellValue)) : cellValue;
                ReflectionUtils.setFieldValue(instance, field.getName(), cellVal);
            }
            result.add(instance);
        }
        return result;
    }

    /**
     * 获取excel表中对应的实体数据
     *
     * @param ins
     * @param headRowNum
     * @param cls
     * @param parseIndex
     * @param excludeAttr
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> getListFromExcel(InputStream ins, int headRowNum, Class<T> cls, int parseIndex, String... excludeAttr) throws Exception {
        List<List<String>> strLists = readFile(ins, headRowNum);
        return getEntityList(strLists, cls, parseIndex, excludeAttr);
    }

    /**
     * 获取excel对应的实体列表
     *
     * @param file        导入的excel文件
     * @param headRowNum  表头行数，记住：从0开始
     * @param cls         实体类
     * @param parseIndex  从哪一行开始解析
     * @param excludeAttr 哪些属性不映射
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> getListFromExcel(MultipartFile file, int headRowNum, Class<T> cls, int parseIndex, String... excludeAttr) throws Exception {
        // try(流)是Java7中的try-with-resource语法。当try语句块运行结束时，InputStream 会被自动关闭，只要实现了AutoCloseable接口的类都可以写在try括号里
        try (InputStream ins = file.getInputStream()) {
            List<List<String>> strLists = readFile(ins, headRowNum);
            return getEntityList(strLists, cls, parseIndex, excludeAttr);
        }
    }


    /**
     * 展示某些属性的方法
     *
     * @param headers
     * @param list
     * @param useXSSF     是否使用2007
     * @param sheetName
     * @param includeAttr
     * @param isInclude
     * @return
     */
    private static <T> Workbook getExcelWorkBook(String[] headers, List<T> list, boolean useXSSF, String sheetName, List<String> includeAttr, boolean isInclude) {
        Workbook workbook = getWorkbook(useXSSF);
        // 创建sheet
        Sheet sheet = workbook.createSheet(sheetName);
        CellStyle cellStyle = getCellStyle(workbook);
        // 创建表头
        createHeader(headers, sheet, useXSSF, cellStyle);
        Field[] fields = null;
        // 确定行数
        for (int i = 0; i < list.size(); i++) {
            // 创建一行
            Row dataRow = sheet.createRow(i + 1);
            T t = list.get(i);
            if (isInclude) {
                // 为每个单元格设值
                for (int j = 0; j < includeAttr.size(); j++) {
                    String fieldName = includeAttr.get(j);
                    formatCell(sheet, cellStyle, dataRow, t, j, fieldName);
                }
            } else {
                fields = fields == null ? t.getClass().getDeclaredFields() : fields;
                // k用来解决某些字段并不在excel中展示带来的数据和列名不匹配问题
                for (int j = 0, k = 0; j < fields.length - 1; j++) {
                    Field field = fields[j];
                    String fieldName = field.getName();
                    // flag标志代表是否不展示该项的值
                    boolean flag = false;
                    if (includeAttr.contains(fieldName)) {
                        // 解决生成数据不匹配问题
                        k++;
                        flag = true;
                        break;
                    }
                    if (flag) continue;

                    formatCell(sheet, cellStyle, dataRow, t, j - k, fieldName);
                }
            }
        }
        return workbook;
    }

    /**
     * 格式化单元格
     * @param sheet
     * @param cellStyle
     * @param dataRow
     * @param t
     * @param j
     * @param fieldName
     * @param <T>
     */
    private static <T> void formatCell(Sheet sheet, CellStyle cellStyle, Row dataRow, T t, int j, String fieldName) {
        Cell dataCell = dataRow.createCell(j);
        dataCell.setCellStyle(cellStyle);
        // 设置固定宽度, 每个单元格可存放16个字符
        sheet.setColumnWidth(j, 16 * 256);
        setCellValue(dataCell, ReflectionUtils.getFieldValue(t, fieldName));
    }

    /**
     * 获取通用style
     *
     * @param workbook
     * @return
     */
    private static CellStyle getCellStyle(Workbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
        return cellStyle;
    }

    private static Workbook getWorkbook(boolean useXSSF) {
        return useXSSF ? new XSSFWorkbook() : new HSSFWorkbook();
    }

    /**
     * 给出字符串的情况下获取WorkBook
     *
     * @param list
     * @return
     */
    public static Workbook getExcelWorkBook(List<List<String>> list, boolean useXSSF) {
        Workbook workbook = getWorkbook(useXSSF);
        // 创建sheet, 名字默认为sheet0
        Sheet sheet = workbook.createSheet("sheet0");
        // 确定行数
        for (int i = 0; i < list.size(); i++) {
            // 创建一行
            Row dataRow = sheet.createRow(i);
            List<String> t = list.get(i);
            // 为每个单元格设值
            for (int j = 0; j < t.size(); j++) {
                Cell dataCell = dataRow.createCell(j);
                // 设置固定宽度, 每个单元格可存放16个字符
                setCellValue(dataCell, t.get(j));
            }
        }
        return workbook;
    }

    /**
     * 创建表头
     *
     * @param headers
     * @param sheet
     */
    private static void createHeader(String[] headers, Sheet sheet, boolean useXSSF, CellStyle commonStyle) {
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell headerRowCell = headerRow.createCell(i);
            headerRowCell.setCellStyle(commonStyle);
            RichTextString text = useXSSF ? new XSSFRichTextString(headers[i]) : new HSSFRichTextString(headers[i]);
            headerRowCell.setCellValue(text);
        }
    }

    /**
     * 为单元格设置值
     *
     * @param dataCell
     * @param value
     */
    public static void setCellValue(Cell dataCell, Object value) {
        if (value instanceof Date) {
            DateFormat sdf = DateUtil.secondFormat.get();
            String zero = "00:00:00";
            if (zero.equals(sdf.format(value).split(" ")[1])) {
                sdf = DateUtil.dayFormat.get();
            }
            dataCell.setCellValue(sdf.format(value));
        } else if (value instanceof Number) {
            dataCell.setCellValue(Double.parseDouble(String.valueOf(value)));
        } else if (value == null) {
            dataCell.setCellValue("");
        } else {
            dataCell.setCellValue(value.toString());
        }
    }


    /**
     * 导出excel ——展示某些属性
     *
     * @param title
     * @param headers
     * @param list
     * @param response
     * @param useXSSF
     * @param sheetName
     * @param includeAttr
     */
    public static void exportExcel(String title, String[] headers, List<?> list, HttpServletResponse response, boolean useXSSF, String sheetName, List<String> includeAttr, boolean isInclude) {
        try {
            Workbook workbook = getExcelWorkBook(headers, list, useXSSF, sheetName, includeAttr, isInclude);
            addMergeArea(workbook, 0, getMergeAreaList());
            writeToResp(title, workbook, response, useXSSF);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 给出导出字符串的情况下的导出方法
     *
     * @param title
     * @param list
     * @param response
     */
    public static void exportExcel(String title, List<List<String>> list, boolean useXSSF, HttpServletResponse response) {
        try {
            Workbook workbook = getExcelWorkBook(list, useXSSF);
            writeToResp(title, workbook, response, useXSSF);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 将excel流写入response
     *
     * @param title
     * @param workbook
     * @param response
     * @param useXSSF
     */
    private static void writeToResp(String title, Workbook workbook, HttpServletResponse response, boolean useXSSF) {
        ServletOutputStream outputStream = null;
        try {
            LOGGER.info("" + workbook);
            outputStream = response.getOutputStream();
            // 解决浏览器及中文乱码问题https://tools.ietf.org/html/rfc2231
            response.setHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + URLEncoder.encode(title, "UTF-8") + (useXSSF ? ".xlsx" : ".xls"));
            response.setContentType("application/msexcel");
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭流资源
            //StreamUtil.close(outputStream, workbook);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 合并单元格并水平垂直居中实现
     *
     * @param areas
     */
    public static void addMergeArea(Workbook workbook, int sheetIndex, List<RectangleArea> areas) {
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            LOGGER.info("Thread: {}, threadLocal is: {}.", Thread.currentThread().getName(), String.valueOf(getMergeAreaList()));
            if (areas != null && areas.size() > 0) {
                for (RectangleArea area : areas) {
                    workbook.getSheetAt(sheetIndex)
                            .addMergedRegion(new CellRangeAddress(area.getFirstRow(), area.getLastRow(), area.getFirstCol(), area.getLastCol()));
                    // 合并单元格时默认居中（水平、垂直居中）
                    CellStyle cellStyle = getCellStyle(workbook);
                    cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
                    cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
                    workbook.getSheetAt(sheetIndex).getRow(area.getFirstRow()).getCell(area.getFirstCol()).setCellStyle(cellStyle);
                }
                mergeAreaList.set(null);
            }
        } finally {
            lock.unlock();
        }
    }

    public static class RectangleArea {
        private int firstRow, lastRow, firstCol, lastCol;

        public RectangleArea(int firstRow, int lastRow, int firstCol, int lastCol) {
            this.firstRow = firstRow;
            this.lastRow = lastRow;
            this.firstCol = firstCol;
            this.lastCol = lastCol;
        }

        public int getFirstRow() {
            return firstRow;
        }

        public int getLastRow() {
            return lastRow;
        }

        public int getFirstCol() {
            return firstCol;
        }

        public int getLastCol() {
            return lastCol;
        }
    }

}