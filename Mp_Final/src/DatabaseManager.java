import java.io.*;
import java.util.*;


public class DatabaseManager implements Serializable{

    public Map<String,Character> obtainDatabaseC() {
        File file = new File("Character.bin");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);

            }
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Map<String,Character> m = (Map<String,Character>) ois.readObject();
            ois.close();
            fis.close();
            return m;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Map<String,History> obtainDatabaseH() {
        File file = new File("History.bin");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Map<String,History> m = (Map<String,History>) ois.readObject();
            ois.close();
            fis.close();
            return m;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public Map<String, User> obtainDatabaseU() {
        File file = new File("User.bin");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Map<String, User> u = (Map<String, User>) ois.readObject();
            ois.close();
            fis.close();
            return u;
        } catch (Exception e) {
            Map<String,Character> a = new HashMap<>();
            saveDatabaseC(a);
            Map<String,List<Challenge>> m = new HashMap<>();
            saveDatabaseP(m);
            Map<String,History> historyMap = new HashMap<>();
            saveDatabaseH(historyMap);
            Map<String,User> u = new HashMap<>();
            saveDatabaseU(u);
            return u;
        }
    }
    public Map<String,List<Challenge>> obtainDatabaseP() {
        File file = new File("Challenge.bin");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Map<String,List<Challenge>> m = (Map<String,List<Challenge>>) ois.readObject();
            ois.close();
            fis.close();
            return m;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveDatabaseC(Map<String,Character> m ) {
        File file = new File("Character.bin");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(m);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveDatabaseH(Map<String,History> m ){
        File file = new File("History.bin");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(m);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveDatabaseU(Map<String, User> m ) {
        File file = new File("User.bin");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(m);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveDatabaseP(Map<String,List<Challenge>> m ) {
        File file = new File("Challenge.bin");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(m);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
