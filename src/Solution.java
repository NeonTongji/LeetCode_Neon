import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    /**
     * SELECT * FROM table t
     * SELECT * FROM table t Where age > 20;
     * {{id, name, age},{1,andy, 10} ...}
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws IOException {
        String fileName = "test.csv";
        String inputSQL = "SELECT * FROM test;";
        // SELECT .... / FROM ..../.....
        String[] strs = inputSQL.split(" ");
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0, prev = 1; i < strs.length; i++) {
            if(strs[i].equals("FROM")) { // TODO 不考虑大小写
                ArrayList<String> fields = new ArrayList<>();
                for(int j = prev; j < i; j++) {
                    fields.add(strs[j]);
                }
                map.put("fields", fields); // 把字段存入
                prev = i;
            }

            if(i == strs.length - 1) {

                ArrayList<String> tableName = new ArrayList<>();
                for(int j = prev + 1; j <= i; j++) {
//                    System.out.println(strs[j]);
                    tableName.add(strs[j].substring(0, strs[j].length() - 1));
                }
                map.put("tableName", tableName); // 把字段存入
                prev = i;
            }
        }

        List<String> tableName = map.get("tableName");
//        System.out.println(tableName);
//        System.out.println(map.get("fields"));

        if(map.get("fields").get(0).equals("*")) {
//            System.out.println(tableName.get(0));
            List<String[]> strings = selectAll(tableName.get(0) + ".csv");

            for(String[] s : strings) {
                for(String field : s) {
                    System.out.print(field + " ");
                }
                System.out.println();
            }

        }



    }

    private static List<String[]> selectAll(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        List<String[]> list = new ArrayList<>();
        String s = bufferedReader.readLine(); //字段名
        String[] filedNames = s.split(" ");
        list.add(filedNames); // 加入了字段
        bufferedReader.lines().forEach(
                item -> {
                    list.add(item.split(" "));
                }
        );

        return list;
    }

//    private static List<String[]> selectFiltering(String fileName, String filterName) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
//        List<String[]> list = new ArrayList<>();
//        String s = bufferedReader.readLine(); //字段名
//        String[] filedNames = s.split(" ");
//        int filetrCol = 0;
//        for(int i = 0; i < filedNames.length; i++) {
//            if(filedNames[i].equals(fileName)) {
//                filetrCol = i;
//            }
//        }
//
//        list.add(filedNames); // 加入了字段
//        String line = "";
//        while ( (line = bufferedReader.readLine()) != null) {
//            String[] fields = line.split(" ");
//            if(fields[filetrCol] > )
//        }
//
//        return list;
//    }





}
