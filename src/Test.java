import javafx.scene.control.Tab;

import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
        CTRL+ALT+L
         */
        boolean bool=true;
        while (bool) {
            System.out.println("请输入用户名：");
            Scanner sc = new Scanner(System.in);
            String username = sc.next();//阻塞方法

            System.out.println("请输入密码：");
            String password = sc.next();

            //File file=new File("C:\\Users\\Administrator\\IdeaProjects\\ConsoleShop\\src\\users.xlsx");
            InputStream in = Class.forName("Test").getResourceAsStream("/users.xlsx");//  /表示的就是classpath

            InputStream inPro = Class.forName("Test").getResourceAsStream("/product.xlsx");//  /表示的就是classpath

            ReadUserExcel readExcel = new ReadUserExcel();//创建对象
            User users[] = readExcel.readExcel(in);
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    bool=false;
                    /*
                    显示商品的信息
                     */
                    ReadProductExcel readProductExcel=new ReadProductExcel();
                    Product products[]=readProductExcel.getAllProduct(inPro);
                    for(Product product:products){
                        System.out.print(product.getId());
                        System.out.print("\t"+product.getName());
                        System.out.print("\t\t"+product.getPrice());
                        System.out.println("\t\t"+product.getDesc());
                    }
                    /*
                    遍历数组
                     */
                    int count=0;
                    Product productes[]=new Product[3];//创建购物车（用数组模拟）
                    System.out.println("请输入商品ID，把该商品加入购物车：");
                    String pId=sc.next();
                    ReadProductExcel readProductExcel1=new ReadProductExcel();
                    inPro=null;
                    inPro = Class.forName("Test").getResourceAsStream("/product.xlsx");//  /表示的就是classpath
                    Product product=readProductExcel1.getProductById(pId,inPro);
                    if(product!=null){
                        /*
                        把商品加入购物车
                         */
                        productes[count++]=product;
                    }
                    break;
                } else {
                    System.out.println("登录失败");
                }
            }
        }
    }
}