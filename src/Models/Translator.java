
package Models;

public class Translator {
    private int translatorID;
    private String fName, lName;

    public Translator(int translatorID, String fName, String lName) {
        this.translatorID = translatorID;
        this.fName = fName;
        this.lName = lName;
    }

    public int getTranslatorID() {
        return translatorID;
    }

    public void setTranslatorID(int translatorID) {
        this.translatorID = translatorID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
    
    
}
