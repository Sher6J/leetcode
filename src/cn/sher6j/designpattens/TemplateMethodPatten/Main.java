package cn.sher6j.designpattens.TemplateMethodPatten;

/**
 * @author sher6j
 * @create 2020-10-30-15:47
 */
public class Main {
    public static void main(String[] args) {
        AbstractDisplay d1 = new CharDisplay('S');
        AbstractDisplay d2 = new StringDisplay("Sher6J");
        d1.display();
        d2.display();
    }
}
