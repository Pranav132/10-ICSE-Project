
class a{
    public static void main(){
        System.out.println("You will now begin to try and figure out the name of the item that is being auctioned");
        System.out.println("To choose the letter you want place, type it's corresponding number");
        System.out.println("After that, type the position of where you want to place the number");
        System.out.println("A few clues:");
        System.out.println("Capital letters will always be at the start of words");
        System.out.println("The number of spaces in the shuffled phrase will determine the number of words in the name of the item.");
        System.out.println("Remember, a space is also counted as a character");
        String shuffledauctionitem = "Pranav Iyengar";
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

            System.out.print(shuffledauctionitem.charAt(a) + "  " );

        }
        System.out.println();
        for(int i = 0; i<shuffledauctionitem.length(); i++){
            System.out.print("_  ");
        }
    }
}