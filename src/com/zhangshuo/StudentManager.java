package com.zhangshuo;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 学生管理系统
 * */
public class StudentManager {
    /*
     * 1.用输出语句完成主页面的编写
     * 2.用Scannar实现键盘录入数据
     * 3.用switch语句完成操作的选择
     * 4.用循环完成再次回到主界面
     * */
    public static void main(String[] args) {
        //创建学生对象，用于存储学生数据
        ArrayList<Student> array = new ArrayList<Student>();
//        用输出语句完成主页面的编写
        while (true) {
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println("请输入您的选择：");

//        用Scannar实现键盘录入数据
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

//        用switch语句完成操作的选择
            switch (line) {
                case "1":
                    //System.out.println("添加学生");
                    addStudent(array);
                    break;
                case "2":
                    //System.out.println("删除学生");
                    deleteStudent(array);
                    break;
                case "3":
                    //System.out.println("修改学生");
                    updateStudent(array);
                    break;
                case "4":
                    //System.out.println("查看所有学生");
                    findAllStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用");
//                    break;
                    System.exit(0);//JVM退出

            }
        }
    }

    //定义一个方法，用于添加学生信息
    public static void addStudent(ArrayList<Student> array) {
        //键盘录入学生对象所需要的数据，显示提示信息，提示要输入何种信息
        Scanner sc = new Scanner(System.in);
        String sid;
        while(true) {
            System.out.println("请输入学生学号：");
            sid = sc.nextLine();
            boolean flag = isUsed(array, sid);
            if (flag) {
                System.out.println("你输入的学号已经存在，请重新输入：");
            }else{
                break;
            }
        }

        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生居住地：");
        String address = sc.nextLine();
        //创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        //将学生对象添加到集合中
        array.add(s);
        //给出添加成功提示
        System.out.println("添加学生成功");
    }
    /*public static void findAllStudent(ArrayList<Student> array){
        //显示表头信息
        System.out.println("学号\t\t\t姓名\t年龄\t\t居住地");
        //将集合中数据取出按照对应格式显示学生信息
        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            System.out.println(s.getSid()+"\t"+s.getName()+"\t"+s.getAge()+"岁\t"+s.getAddress());
        }
    }*/
    public static void findAllStudent(ArrayList<Student> array){
        //判断集合中是否有信息，如果没有显示提示信息。
        if(array.size()==0) {
            System.out.println("无信息，请先添加信息");
            return;
        }
        //显示表头信息
        System.out.println("学号\t\t\t姓名\t\t年龄\t\t居住地");
        //将集合中数据取出按照对应格式显示学生信息
        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            System.out.println(s.getSid()+"\t"+s.getName()+"\t\t"+s.getAge()+"岁\t"+s.getAddress());
        }
    }
    public static boolean isUsed(ArrayList<Student> array,String sid) {
        boolean flag = false;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getSid().equals(sid)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    public static void deleteStudent(ArrayList<Student> array){
        //键盘录入要删除的学生学号，显示提示信息
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的学生学号；");
        String sid = sc.nextLine();
        //遍历集合将对应的学生对象从集合删除
        int index = -1;
        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            if(s.getSid().equals(sid)){
                index = i;
            }
        }
        if(index == -1){
            System.out.println("你输入的学生学号不存在，请重新输入：");
        }else{
            array.remove(index);
            //给出删除成功提示
            System.out.println("删除学生成功");
        }


    }
    public static void updateStudent(ArrayList<Student> array){
        //键盘录入要修改的学生学号，显示提示信息
        Scanner sc  = new Scanner(System.in);
        System.out.println("请输入你要修改的学生学号：");
        String sid = sc.nextLine();
        //键盘录入要修改的学生信息
        System.out.println("请输入你要修改的新姓名：");
        String name = sc.nextLine();
        System.out.println("请输入你要修改的新年龄：");
        String age = sc.nextLine();
        System.out.println("请输入你要修改的新居之地：");
        String address = sc.nextLine();
        //创建学生对象
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        //遍历集合修改对应的学生信息
        int index = -1;
        int i;
        for( i =0;i<array.size();i++){
            Student student = array.get(i);
            if(student.getSid().equals(sid)){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("你输入的学号有误，请重新输入：");
        }else{
            array.set(i,s);
            //给出修改成功提示
            System.out.println("修改学生成功");
        }

    }

}