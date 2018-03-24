package com.lzwing.testcode.idgenerator;

/**
 * @Description:ID
 * @author:rongshaolin
 * @date:2017-08-31 19:43
 */
public class IdGenerator {

    private static SnowflakeIdWorker snowflakeIdWorker;
    /**
     * 项目
     */
    private static Long project;
    /**
     * 节点
     */
    private static Long node;


    volatile private static IdGenerator instance = null;

    /**
     * @param pd 项目定义 project define （区分不同项目），从1开始到31
     * @param id 节点ID，从1开始到31
     */
    public IdGenerator(Long pd, Long id) {

        if (pd > 31 || pd < 0) {
            throw new IllegalArgumentException(String.format("项目标识不能大于31"));
        }

        if (id > 31 || id < 0) {
            throw new IllegalArgumentException(String.format("节点数字不能大于31"));
        }

        if(this.node !=null && this.node >0){
            throw new IllegalArgumentException(String.format("IdGenerator只初始化一次"));
        }

        this.node = id;
        snowflakeIdWorker = new SnowflakeIdWorker(pd, this.node);
    }

    /**
     * 获得一个唯一的ID
     * @return
     */
    public static Long getId(){

        return snowflakeIdWorker.nextId();

    }

    /*public static void main(String[] args) {

        Long node = IdGenerator.getNode();
        System.out.println(node);

        new IdGenerator(31L);
        node = IdGenerator.getNode();
        System.out.println(node);

        new IdGenerator(30L);
        node = IdGenerator.getNode();
        System.out.println(node);

        new IdGenerator(29L);
        node = IdGenerator.getNode();
        System.out.println(node);

    }*/

//    public static void main(String[] args) {
//        System.out.println(-1L^(-1L<<10));
//    }

}