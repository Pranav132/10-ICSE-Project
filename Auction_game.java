import java.util.*;

class Auction_game{
    static Scanner sc = new Scanner(System.in);
    static double bal = 1000.0;
    static String inventory[] = {"","","","",""};
    static int inventorycost[]={0,0,0,0,0};
    public static void main(String args [])
    {
        System.out.println("Welcome to the game. Please enter your name");
        String name = sc.nextLine();
        System.out.println("Welcome " + name + ". Your balance is " + bal);
        Menu();

    }    

    static void Menu()
    {
        System.out.println("Welcome to the main menu");
        System.out.println("You can - ");
        System.out.println("1)read about the rules");
        System.out.println("2)Choose a blind auction to participate in ");
        System.out.println("3)Sell items ");
        System.out.println("4)Look at your inventory ");
        System.out.println("5)or quit the game");
        System.out.println(" Type the number of the section you want to go to ");
        int menu1 = sc.nextInt();
        boolean menuloop = true;
        while(menuloop == true){
            switch(menu1)
            {
                case 1:
                call_rules();
                menuloop = false;
                break;
                case 2:
                if(inventory[4] != ""){
                    System.out.println("You already have 5 items. Please sell one before trying to enter an auction.");
                    Menu();
                }
                else{
                    call_auction();
                }
                menuloop = false;
                break;
                case 3:
                call_sell_items();
                menuloop = false;
                break;
                case 4:
                call_inventory();
                menuloop = false;
                break;
                case 5:
                call_quit();
                menuloop = false;
                break;

            }
        }
    }

    static void call_rules()
    {
        // print the rules
        System.out.println("You start the game with 1000 rupees in your account.");
        System.out.println("The first thing you need to do is join a blind auction.");
        System.out.println("In the auction, you will be given an anagram of the name of the object you are bidding on.");
        System.out.println("To win the auction,you must out bid the computer. If you win the auction, the moeny will be removed from your account.");
        System.out.println("If you do not win the auction, your balance will stay the same and you can enter another auction. ");
        System.out.println("Once you have won an item, it will be stored in your inventory. You can keep a maximum of 5 items at a time.");
        System.out.println("You can either sell the item, for a fixed amount, or you can auction the item you have bought. The amount of money you receive from the auction is not fixed.");
        System.out.println("If your balance goes above 20000 rupees, you have won the game. If your balance goes below 200 rupees, and you have no item in your inventory, you have lost the game. ");
        System.out.println("You will be returned to the menu");
        Menu();
    }

    static void call_auction()
    {
        boolean flag = true;
        String auctionitem="";
        int auctionitemcost = 0;
        String shuffledauctionitem = "";
        // array with diff items in it
        // scramble up the word in the array everytime
        // certian amoutn of money fixed for each item that the comptuer knows
        // player can bid on it and the comp wont go above the fixed amoutn
        // if the player outbids the comp he gets the item
        // if the comp outbids the player he doesnt get the item

        String itemsbelow1k[] = {"x", "Desk Lamp", "Keyboard", "Book of poems", "Minature Buddha" , "Perfume"};
        int costs1k[] = {4, 660, 750, 699, 999, 450};
        String itemsbw2and5k[] = {"x", "Vinyl CDs", "Autographed Football", "Body length mirror", "Backpack", "Extra Large Lego Set"};
        int costs2k[]= {4, 2250, 4425, 3750, 2499, 3500};
        String items10k[] = {"x", "Car Tires", "RC Drone", "PSP", "HD Monitor", "Crystal Vase"};
        int costs10k[] ={4, 7999, 6500, 5999, 8750, 9999};
        int random = (int)( Math.random() * 5 + 1);
        if (bal <= 3500){
            auctionitem = itemsbelow1k[random];
            auctionitemcost = costs1k[random];
        }  
        else if (bal >=3501 && bal <= 7500){
            auctionitem = itemsbw2and5k[random];
            auctionitemcost = costs2k[random];
        }
        else{
            auctionitem = items10k[random];
            auctionitemcost = costs10k[random];
        }
        shuffledauctionitem = shuffle(auctionitem);
        System.out.println("The anagram of the item in auction is '" + shuffledauctionitem + "'");

        int bid = 0;

        while (flag == true){
            System.out.println("If you want to continue with this auction, type 1. If you want to leave and go back to the menu, type 2.");
            int auctionstayorleave = sc.nextInt();

            switch (auctionstayorleave){
                case 1:

                System.out.println("Your current bid is " + bid + ". How much more do you want to bid?");
                int sum = sc.nextInt();
                bid += sum;
                System.out.println("Your bid is now " + bid);
                int counterbid, r;
                if (bid > bal){
                    System.out.println("Do not have enough money");
                    bid-=sum;
                    flag = true;
                }
                else{
                    if(bid > auctionitemcost){
                        System.out.println("You have won the auction ");
                        bal = bal - bid;
                        for (int i = 0; i < inventory.length; i++){
                            if (inventory[i]== ""){
                                inventory[i] = auctionitem;
                                inventorycost[i]=auctionitemcost;
                                System.out.println("The item you have won is " + auctionitem);
                                flag = false;
                                Menu();
                                break;
                            }
                        }
                    }
                    else{
                        counterbid = (int)( bid + (Math.random() * (auctionitemcost - bid)) );
                        if(counterbid == bid){
                            counterbid = counterbid + 1;
                            System.out.println("You have been outbid by a bid of " + counterbid);
                        }
                        if (counterbid > bid){
                            System.out.println(" You have been outbid by a bid of " + counterbid);
                            if(counterbid > bal){
                                System.out.println("This item is too costly for you at this point. You will be removed from this auction. Please join another one.");
                                flag = false;
                                Menu();
                            }
                        }

                    }

                }
                break;
                case 2:
                Menu();
                flag = false;
                break;
            }
        }
    }

    static String shuffle(String auctionitem){
        String shuffledvalue = ""; 
        while (auctionitem.length() != 0)
        {
            int removed = (int) Math.floor(Math.random() * auctionitem.length());
            char L = auctionitem.charAt(removed);            
            auctionitem = auctionitem.substring(0,removed)+auctionitem.substring(removed+1);
            shuffledvalue += L;
        }
        return shuffledvalue;
    }

    static void call_sell_items()
    {
        System.out.println("Welcome to the item selling menu. Over here, you can either sell an item for a fixed amount, or auction an item for a random amount.");   
        System.out.println( " The auction has a greater risk as you can lose money, but you can also gain more."); 
        System.out.println( "You currently have in your inventory:"); 
        for (int i = 0; i < 5; i ++){

            System.out.println(i+1 + ")" + inventory[i]);

        }
        int aucbid = 0;
        int liveab = 0;
        boolean eh = true;
        while(eh == true){
            System.out.println("Type 1 to continue seling items, type 2 to go back to the menu");
            int ehc = sc.nextInt();
            switch(ehc){
                case 1:
                System.out.println("Type the number of the item you want to sell or auction");
                int cs = sc.nextInt() -1;

                String csitem = inventory[cs];
                int cscost = inventorycost[cs];
                if (csitem == ""){
                    System.out.println("No item in that slot");
                }
                else{

                    int cssp = (int) (cscost + (Math.random() * cscost));
                    System.out.println("The price for selling this item at this point in time is " + cssp);
                    System.out.println("You can come back at a later date for a different price, or you can sell the item at this rate now");
                    System.out.println("You can also put this item on the auction block");
                    boolean bool = true;
                    while (bool == true){
                        System.out.println("Enter 1 for selling, 2 for auction, 3 for coming back later");
                        int sch = sc.nextInt();
                        if(sch == 1){
                            inventory[cs] = "";
                            bal += cssp;
                            System.out.println("Item has been sold and your balance is now " + bal);
                            Menu();
                            break;

                        }
                        else if(sch == 2){
                            aucbid = (int)(Math.random()*cscost);
                            liveab = (int)((Math.random() * aucbid));
                            System.out.println("Aucbid: " + aucbid);
                            System.out.println("Item " + csitem + "is up for auction with a starting bid of " + liveab);
                            System.out.println("Does anyone want to bid?");
                            System.out.println("Person in the back raises his hand up");
                            System.out.println("Does anyone else want to counterbid?");
                            int arrat=(int)(Math.random() * (aucbid - liveab));
                            liveab += arrat;
                            System.out.println("The new bid is now " + liveab);
                            int liveabgoing = (int)(Math.random() * 2);
                            for (int q = 1; q <= liveabgoing; q++){
                                if (q == 1){
                                    System.out.println ("Going once");
                                    System.out.println("Does anyone else want to bid?");
                                }
                                else{
                                    System.out.println ("Going twice");
                                    System.out.println("Does anyone else want to bid?");
                                }
                            }
                            System.out.println("Person in the back raises his hand up");
                            liveab = aucbid;
                            System.out.println("The new bid is now " + liveab);
                            System.out.println ("Going once");
                            System.out.println("Does anyone else want to bid?");
                            System.out.println ("Going twice");
                            System.out.println("Does anyone else want to bid?");
                            System.out.println("Going thrice");
                            System.out.println("Sold for " + liveab);
                            inventory[cs] = "";
                            bal += cssp;
                            System.out.println("Item has been sold and your balance is now " + bal);
                            Menu();
                            break;

                        }
                        else if (sch == 3){
                            System.out.println("Going back to menu now");
                            Menu();
                            break;
                        }
                        else{
                            System.out.println("Invalid output");
                            bool = true;
                        }

                    }
                    eh = false;
                }
                break; 
                case 2: 
                Menu();
                eh = false;
                break;
            }
        } 
    }

    static void call_inventory()
    {

        System.out.println("Welcome to the inventory");   
        System.out.println("You currently have in your inventory:");

        System.out.println( "You currently have in your inventory:"); 
        for (int i = 0; i < 5; i ++){

            System.out.println(i+1 + ")" + inventory[i]);

        }

        System.out.println("Your balance is " + bal);
        System.out.println("You will be returned to the menu now");
        Menu();
    }

    static void call_quit()
    {

        System.out.println("Game over. The program is closing now.");             
    }               
}
