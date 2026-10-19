package model;

import java.io.*;

import java.util.HashMap;
import java.util.Map;


public class WordMap {
    private HashMap <String ,Word> wordMap = new HashMap<>();
    private final String filePath; //final bắt buộc biến đó phải được gán giá trị ngay khi
    // đối tượng WordMap vừa được tạo ra


    public WordMap(String filePath) {
        this.filePath = filePath;
        loadfile();
    }

    private void loadfile() {
        //Tạo một đối tượng đại diện cho file dữ liệu dựa trên đường dẫn
        File file = new File(filePath);
        if (!file.exists()) {
            createNewFile(file);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] str = line.split(":");
                if (str.length == 2) {
                    String eng = str[0].trim();
                    String vie = str[1].trim();
                    wordMap.put(eng.toLowerCase(), new Word(eng, vie));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createNewFile (File file){
            try{
            File cha = file.getParentFile(); //file.getParentFile() lấy thư mục chứa file
            if ( cha != null && !cha.exists() ){
                cha.mkdirs(); //tạo cả chuỗi thư mục cha còn thiếu
            }
            file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
        }
    }

    private void updateDatabase(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, Word>entry:wordMap.entrySet()){
                Word w = entry.getValue();
                bw.write(w.getEng().toLowerCase()+ ":" +w.getVie());
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public boolean addWord (Word w){
        if (w == null || w.getEng() == null || w.getEng().trim().isEmpty()){
            return false;
        }
        wordMap.put(w.getEng().toLowerCase().trim(), w);
        updateDatabase();
        return true;
    }

    public boolean deleteWord (String eng){
        if (eng != null && isExistWord(eng)){
            wordMap.remove(eng.toLowerCase().trim());
            updateDatabase();
            return true;
        }
        return false;

    }

    public boolean isExistWord (String eng){
        if (eng == null ) return false;
        return wordMap.containsKey(eng.toLowerCase().trim());
    }

    public Word searchWord (String eng){
        if (eng == null) return null;
        return wordMap.get(eng.toLowerCase().trim());
    }

}
