package com.lzwing.testcode.mockito;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/7/10
 * Time: 17:53
 */
@Slf4j
public class Tester {

//    @Mock
    


    @Test
    public void test() {
        // Mock creation
        List mockedList = mock(List.class);

        // Use mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one"); //调用了add("one")行为
        mockedList.clear(); //调用了clear()行为

        // Selective, explicit, highly readable verification
        verify(mockedList).add("one"); // 检验add("one")是否已被调用
        verify(mockedList).clear(); // 检验clear()是否已被调用
    }

    @Test
    public void test1() {
        // you can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);
        // stubbing appears before the actual execution
        when(mockedList.get(0)).thenReturn("first");
        // the following prints "first"
        System.out.println(mockedList.get(0));
        // the following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));
    }

    @Test
    public void test2() throws Exception{
        MultipartFile multipartFile = Mockito.mock(MultipartFile.class);
        multipartFile.transferTo(new File("/"));

//        Mockito.when(multipartFile.transferTo(new File("/")));

        Mockito.verify(multipartFile).transferTo(new File("/"));
    }
}
