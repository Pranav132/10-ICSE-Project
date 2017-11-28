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
            int cc = shuffledauctionitem.charAt(i);

            if((cc <= 90 && cc >= 65)  || cc == 32){
                System.out.print(shuffledauctionitem.charAt(i) + "  ");
                pp  = shuffledauctionitem.charAt(i);
            }
            else{
                System.out.print("_  ");
                pp = '_';
            }
            scr+=pp;
        }
        System.out.println();
        System.out.println();

        System.out.println("Enter 1 for choosing letter from anagram, enter 2 for letter from the solution,enter 3 to stop trying to solve the anagram.");
        int anac = sc.nextInt();
        boolean flag1 = true;
        while(flag1 = true){
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
                    if (scr.charAt(q - 1) == '_'){
                        System.out.println("Character has already been placed.");

                    }
                    else{
                        scr.charAt(q-1) = sch.charAt(r-1);
                        System.out.println("Letter has been shifted.");
                        flag1 = false;
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
                    if (sch.charAt(s - 1) == '~'){
                        System.out.println("Character has already been placed.");

                    }
                    else{
                        sch.charAt(s-1) = scr.charAt(r-1);
                        System.out.println("Letter has been shifted.");
                        flag1 = false;
                    }
                }
                break;
                case 3:
                System.out.println("You wil be returned to the auction now.");
                flag1 = false;
                break;
                case default:
                System.out.println("Error");
            }
        }
    }
}
