import javafx.scene.control.Tab;

import java.io.InputStream;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
        CTRL+ALT+L
         */
        boolean bool = true;
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
                    bool = false;
                    /*
                    显示商品的信息
                     */
                    ReadProductExcel readProductExcel = new ReadProductExcel();
                    Product products[] = readProductExcel.getAllProduct(inPro);
                    for (Product product : products) {
                        System.out.print(product.getId());
                        System.out.print("\t" + product.getName());
                        System.out.print("\t\t" + product.getPrice());
                        System.out.println("\t\t" + product.getDesc());
                    }
                    /*
                    遍历数组
                     */
                    int count = 0;
                    Product carts[] = new Product[3];//创建购物车（用数组模拟）
                    System.out.println("请输入商品ID，把该商品加入购物车：");
                    String pId = sc.next();
                    ReadProductExcel readProductExcel1 = new ReadProductExcel();
                    inPro = null;
                    inPro = Class.forName("Test").getResourceAsStream("/product.xlsx");//  /表示的就是classpath
                    Product product = readProductExcel1.getProductById(pId, inPro);
                    if (product != null) {
                        /*
                        把商品加入购物车
                         */
                        carts[count++] = product;
                    }
                    System.out.println("查看购物车请按《1》");
                    System.out.println("继续购物请按《2》");
                    int choose = sc.nextInt();
                    if (choose == 1) {
                        for (int j = 0; j < carts.length; j++) {
                            if (carts[j] != null) {
                                System.out.print(carts[j].getId());
                                System.out.print("\t" + carts[j].getName());
                                System.out.print("\t\t" + carts[j].getPrice());
                                System.out.println("\t\t" + carts[j].getDesc());
                            }
                        }
                    } else if (choose == 2) {
                        readProductExcel = new ReadProductExcel();
                        inPro = null;
                        inPro = Class.forName("Test").getResourceAsStream("/product.xlsx");//  /表示的就是classpath
                        products = readProductExcel.getAllProduct(inPro);
                        for (Product p : products) {
                            System.out.print(p.getId());
                            System.out.print("\t" + p.getName());
                            System.out.print("\t\t" + p.getPrice());
                            System.out.println("\t\t" + p.getDesc());
                        }
                    /*
                    遍历数组
                     */
                        System.out.println("请输入商品ID，把该商品加入购物车：");
                        pId = sc.next();
                        readProductExcel1 = new ReadProductExcel();
                        inPro = null;
                        inPro = Class.forName("Test").getResourceAsStream("/product.xlsx");//  /表示的就是classpath
                        Product product1 = readProductExcel1.getProductById(pId, inPro);
                        if (product != null) {
                        /*
                        把商品加入购物车
                         */
                            carts[count++] = product1;
                        }
                    }
                    System.out.println("查看购物车请按《1》");
                    System.out.println("继续购物请按《2》");
                    choose = sc.nextInt();
                    if (choose == 1) {
                        for (int j = 0; j < carts.length; j++) {
                            if (carts[j] != null) {
                                System.out.print(carts[j].getId());
                                System.out.print("\t" + carts[j].getName());
                                System.out.print("\t\t" + carts[j].getPrice());
                                System.out.println("\t\t" + carts[j].getDesc());
                            }
                        }
                    } else if (choose == 2) {
                        readProductExcel = new ReadProductExcel();
                        inPro = null;
                        inPro = Class.forName("Test").getResourceAsStream("/product.xlsx");//  /表示的就是classpath
                        products = readProductExcel.getAllProduct(inPro);
                        for (Product p : products) {
                            System.out.print(p.getId());
                            System.out.print("\t" + p.getName());
                            System.out.print("\t\t" + p.getPrice());
                            System.out.println("\t\t" + p.getDesc());
                        }
                    /*
                    遍历数组
                     */
                        System.out.println("请输入商品ID，把该商品加入购物车：");
                        pId = sc.next();
                        readProductExcel1 = new ReadProductExcel();
                        inPro = null;
                        inPro = Class.forName("Test").getResourceAsStream("/product.xlsx");//  /表示的就是classpath
                        Product product1 = readProductExcel1.getProductById(pId, inPro);
                        if (product != null) {
                        /*
                        把商品加入购物车
                         */
                            carts[count++] = product1;
                        }
                    }
                    /*
                    1、查看购物车
                    （1）购物车是用数组模拟的
                    （2）就是把数组内的元素一个一个找出来：对数组遍历
                    2、继续购物
                    （1）又要显示所有商品
                     */

                    break;
                } else {
                    System.out.println("登录失败");
                }
            }
        }
    }
}