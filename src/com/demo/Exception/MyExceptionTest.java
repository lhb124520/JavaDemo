package com.demo.Exception;

public class MyExceptionTest {

	public static void main(String[] args) {		
		String[] sexs = {"����","Ů��","����"};
        for(int i = 0; i < sexs.length; i++){
            if("����".equals(sexs[i])){
                throw new MyException("��ȫ�Ҷ������ԣ�");
            }else{
                System.out.println(sexs[i]);
            }
        } 
	}

}
