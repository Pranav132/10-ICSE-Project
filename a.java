import java.util.*;
class a {
    public static void main(){
        Scanner sc = new Scanner(System.in);
        System.out.println("You will now begin to try and figure out the name of the item that is being auctioned");
        System.out.println("To choose the letter you want place, type it's corresponding number");
        System.out.println("After that, type the position of where you want to place the number");
        System.out.println("A few clues:");
        System.out.println("Capital letters will always be at the start of words");
        System.out.println("The number of spaces in the shuffled phrase will determine the number of words in the name of the item.");
        System.out.println("Remember, a space is also counted as a character. The spaces have been entered in their correct placed for you. In it's place");
        System.out.println("The characters which have been placed have been replaced by a '~'");
        String shuffledauctionitem = "Penguin Lamp Keyboard";
        String auctionitem = "Lamp Penguin Keyboard";
        String scrne = "", schne = "";
        char j =' ';
        for(int i = 0; i<shuffledauctionitem.length(); i++){
            if (i<9){
                System.out.print("0"+(i + 1) + " ");
            }
            else{
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println();
        char qq;
        String sch ="";
        for (int a = 0; a<shuffledauctionitem.length();a++){

            int dd = shuffledauctionitem.charAt(a);

            if((dd <= 90 && dd >= 65)  ||dd == 32){
                System.out.print("~  ");
                qq = '~';
            }
            else{
                System.out.print(shuffledauctionitem.charAt(a) + "  " );
                qq = shuffledauctionitem.charAt(a);
            }
            sch+= qq;
        }
        System.out.println();
        System.out.println();
        for(int i = 0; i<shuffledauctionitem.length(); i++){
            if (i<9){
                System.out.print("0"+(i + 1) + " ");
            }
            else{
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println();
        char pp;
        String scr ="";
        for(int i = 0; i<shuffledauctionitem.length(); i++){
            int cc = auctionitem.charAt(i);

            if((cc <= 90 && cc >= 65)  || cc == 32){
                System.out.print(auctionitem.charAt(i) + "  ");
                pp  = auctionitem.charAt(i);
            }
            else{
                System.out.print("_  ");
                pp = '_';
            }
            scr+=pp;
        }
        System.out.println();
        System.out.println();

        boolean flag1 = true;
        while(flag1 == true){
            System.out.println("Enter 1 for choosing letter from anagram, enter 2 for letter from the solution");
            int anac = sc.nextInt();

            switch(anac){
                case 1: 
                System.out.println("Enter the corresponding number of the letter you want to move from the anagram");

                int r = sc.nextInt();
                if (sch.charAt(r - 1) == '~'){
                    System.out.println("Character has already been placed.");
                    // || scr.charAt(r - 1) == '_'
                }
                else{
                    System.out.println("Enter the corresponding number of the position you want to place the letter in");
                    int q = sc.nextInt();
                    if (scr.charAt(q - 1) != '_'){
                        System.out.println("Character has already been placed.");

                    }
                    else{
                        //char j = sch.charAt(r-1);
                        //scr.charAt(q-1) = j;
                        for (int i = 0; i <scr.length(); i ++){
                            if(i == (q-1)){
                                j = sch.charAt(r-1);
                            }
                            else{
                                j = scr.charAt(i);
                            }
                            scrne+=j;
                        }
                        for(int i = 0; i <sch.length(); i++){
                            if(i == (q-1)){
                                j = '~';
                            }
                            else{
                                j = sch.charAt(i);
                            }
                            schne+=j;
                        }
                        System.out.println("Letter has been shifted.");
                        flag1 = false;
                    }
                }
                break;
                case 2:
                System.out.println("Enter the corresponding number of the letter you want to move from the solution");

                int l = sc.nextInt();
                if (scr.charAt(l - 1) == '_'){
                    System.out.println("No character is in that position.");
                    // || scr.charAt(r - 1) == '_'
                }
                else{
                    System.out.println("Enter the corresponding number of the position you want to place the letter in");
                    int s = sc.nextInt();
                    if (sch.charAt(s - 1) != '~'){
                        System.out.println("Character has already been placed.");

                    }
                    else{
                        //sch.charAt(s-1) = scr.charAt(r-1);
                        for (int i = 0; i <scr.length(); i ++){
                            if(i == (s-1)){
                                j = scr.charAt(l-1);
                            }
                            else{
                                j = sch.charAt(i);
                            }
                            schne+=j;
                        }
                        for(int i = 0; i <sch.length(); i++){
                            if(i == (s-1)){
                                j = '_';
                            }
                            else{
                                j = scr.charAt(i);
                            }
                            scrne+=j;
                        }
                        System.out.println("Letter has been shifted.");

                        flag1 = false;
                    }
                }
                break;
                default:
                System.out.println("Error");
                break;
            }
        }
        boolean flag3 = true;
        System.out.println(sch);
        System.out.println(scr);
        while(flag3 == true){
            System.out.println("Next Loop");
            scr = scrne;
            sch = schne;

            System.out.println("sch" + sch);
            System.out.println(scr);
            if (scr.equals(auctionitem) == true){
                System.out.println("You have solved the anagram");
                flag3 = false;
                //range
            }
            else{

                for(int i = 0; i<shuffledauctionitem.length(); i++){
                    if (i<9){
                        System.out.print("0"+(i + 1) + " ");
                    }
                    else{
                        System.out.print(i + 1 + " ");
                    }
                }
                System.out.println();
                for (int a = 0; a<shuffledauctionitem.length();a++){

                    int dd = sch.charAt(a);

                    if((dd <= 90 && dd >= 65)  ||dd == 32){
                        System.out.print("~  ");

                    }
                    else{
                        System.out.print(sch.charAt(a) + "  " );

                    }

                }
                System.out.println();
                System.out.println();
                for(int i = 0; i<shuffledauctionitem.length(); i++){
                    if (i<9){
                        System.out.print("0"+(i + 1) + " ");
                    }
                    else{
                        System.out.print(i + 1 + " ");
                    }
                }
                System.out.println();

                for(int i = 0; i<shuffledauctionitem.length(); i++){
                    int cc = scr.charAt(i);

                    if((cc <= 90 && cc >= 65)  || cc == 32){
                        System.out.print(scr.charAt(i) + "  ");

                    }
                    else{
                        System.out.print("_  ");

                    }

                }

                System.out.println("Enter 1 for choosing letter from anagram, enter 2 for letter from the solution");
                int anac1 = sc.nextInt();
                boolean flag2 = true;
                while(flag2 = true){
                    switch(anac1){
                        case 1: 
                        System.out.println("Enter the corresponding number of the letter you want to move from the anagram");

                        int r = sc.nextInt();
                        if (sch.charAt(r - 1) == '~'){
                            System.out.println("Character has already been placed.");
                            // || scr.charAt(r - 1) == '_'
                        }
                        else{
                            System.out.println("Enter the corresponding number of the position you want to place the letter in");
                            int q = sc.nextInt();
                            if (scr.charAt(q - 1) != '_'){
                                System.out.println("Character has already been placed.");

                            }
                            else{
                                //char j = sch.charAt(r-1);
                                //scr.charAt(q-1) = j;
                                for (int i = 0; i <scr.length(); i ++){
                                    if(i == (q-1)){
                                        j = sch.charAt(r-1);
                                    }
                                    else{
                                        j = scr.charAt(i);
                                    }
                                    scrne+=j;
                                }
                                for(int i = 0; i <sch.length(); i++){
                                    if(i == (q-1)){
                                        j = '~';
                                    }
                                    else{
                                        j = sch.charAt(i);
                                    }
                                    schne+=j;
                                }
                                System.out.println("Letter has been shifted.");
                                flag2 = false;
                            }
                        }
                        break;
                        case 2:
                        System.out.println("Enter the corresponding number of the letter you want to move from the solution");

                        int l = sc.nextInt();
                        if (scr.charAt(l - 1) == '_'){
                            System.out.println("No character has in that position.");
                            // || scr.charAt(r - 1) == '_'
                        }
                        else{
                            System.out.println("Enter the corresponding number of the position you want to place the letter in");
                            int s = sc.nextInt();
                            if (sch.charAt(s - 1) != '~'){
                                System.out.println("Character has already been placed.");

                            }
                            else{
                                //sch.charAt(s-1) = scr.charAt(r-1);
                                for (int i = 0; i <scr.length(); i ++){
                                    if(i == (s-1)){
                                        j = scr.charAt(l-1);
                                    }
                                    else{
                                        j = sch.charAt(i);
                                    }
                                    schne+=j;
                                }
                                for(int i = 0; i <sch.length(); i++){
                                    if(i == (s-1)){
                                        j = '_';
                                    }
                                    else{
                                        j = scr.charAt(i);
                                    }
                                    scrne+= j;
                                }
                                System.out.println("Letter has been shifted.");
                                flag1 = false;
                            }
                        }
                        break;
                        default:
                        System.out.println("Error");
                        break;
                    }
                }

            }
        }
    }

}
