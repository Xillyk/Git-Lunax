public class Monster {
    
    int monsDmg;
    int monsLv;
    int monsExp;
    int monsHp;

    public Monster() {
        //set damage of monster
        monsDmg = 20;
        monsLv = 1;
        monsExp = 10;
        monsHp = 10;
    }

    
    //Monster level up!!
    public void monsStatusUp() {
        // System.out.println("Hey Hey");
        monsLv++;
        monsDmg = monsDmg * monsLv;
        monsHp = (int)(monsHp*monsLv*0.6);
        monsExp = monsExp * monsLv;
        // System.out.println(getMonsLv());
        // System.out.println(getMonsDmg());

    }

}