import java.util.*;

class Auction_Land{
    static double bal = 1000.0;
    static String inventory[] = {"","","","",""};
    static int inventorycost[]={0,0,0,0,0};
    static int choo = 0;
    public static void main(String args [])
    {
        String name = "";
        Scanner sc = new Scanner(System.in);

        System.out.println("      e      888   |  e88~-_  ~~~888~~~ 888   ,88~-_   888b    |   888          e      888b    | 888~-_   ");
        System.out.println("     d8b     888   | d888   \\    888    888  d888   \\  |Y88b   |   888         d8b     |Y88b   | 888   \\   ");
        System.out.println("    /Y88b    888   | 8888        888    888 88888    | | Y88b  |   888        /Y88b    | Y88b  | 888    |  ");
        System.out.println("   /  Y88b   888   | 8888        888    888 88888    | |  Y88b |   888       /  Y88b   |  Y88b | 888    | ");
        System.out.println("  /____Y88b  Y88   | Y888   /    888    888  Y888   /  |   Y88b|   888      /____Y88b  |   Y88b| 888   / ");
        System.out.println(" /      Y88b  \"8__/   \"88_-~     888    888   `88_-~   |    Y888   888____ /      Y88b |    Y888 888_-~  ");

        System.out.println("\n\n______________________________________________________________________________________________________________________________\n\n");
        while (true){
            System.out.println("Welcome to the game 'Auction Land'. Please enter your name. It should not be longer than 20 characters.\n");
            name = sc.nextLine();
            name = name.trim();

            int count = 0;
            for(int i = 0; i < name.length(); i++){
                if((name.charAt(i) >= 97 && name.charAt(i) <= 122) || (name.charAt(i) <= 90 && name.charAt(i) >= 65) || name.charAt(i) == 32){
                    count++;
                }
            }
            if(name.length() <= 20 && count == name.length()){
                break;
            }
            else if(name.length() > 20){
                System.out.println("Name is too long");
            }
            else if(count != name.length()){
                System.out.println("Enter only letters");
            }
        }

        System.out.println("Welcome " + name + ". Your balance is " + bal + " rupees");
        Menu();

    }    

    static void Menu()
    {

        int count = 0;
        for (int i = 0; i < 5; i ++){

            if(inventory[i] == ""){
                count++;
            }
        } 
        if(count == 5 && bal < 200){
            System.out.println("You have lost the game as you have nothing in your inventory and your balance is below 200 rupees.");
            call_quit();
        }
        else if (bal > 20000){
            System.out.println("You have won the game as your balance is above 20000 rupees.");
            call_quit();
        }
        else{
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Welcome to the main menu");
            System.out.println("You can - ");
            System.out.println("\n1)read about the rules");
            System.out.println("\n2)Choose a blind auction to participate in ");
            System.out.println("\n3)Sell items ");
            System.out.println("\n4)Look at your inventory ");
            System.out.println("\n5)or quit the game"); 
            System.out.println("\n\n");
            int menu1 = 0;
            boolean flaggg = true;
            while(flaggg == true)
            {

                Scanner sc = new Scanner(System.in);            
                try
                {
                    System.out.println(" Type the number of the section you want to go to ");

                    menu1 = sc.nextInt();
                }
                catch (Exception e)
                {
                    sc.nextLine(); 
                    System.out.println("Enter only integers");
                }
                finally{
                    sc.close();
                }
                if(menu1> 0 && menu1 < 6){
                    flaggg = false;
                }
                else{
                    System.out.println("Error");
                }
            }

            boolean menuloop = true;
            while(menuloop == true)
            {
                switch(menu1)
                {
                    case 1:
                    call_rules();
                    menuloop = false;
                    break;
                    case 2:
                    int invvcount = 0;
                    for (int i = 0; i < 5; i ++){

                        if(inventory[i] != ""){
                            invvcount++;
                        }
                    }
                    if(invvcount == 5){
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
    }

    static void call_rules()
    {
        // print the rules
        System.out.println("\n\n");
        System.out.println("You start the game with 1000 rupees in your account.");
        System.out.println("The first thing you need to do is join a blind auction.");
        System.out.println("In the auction, you will be given an anagram of the name of the object you are bidding on. ");
        System.out.println("You can either solve the anagram of the item to get a price range of the item, or enter the auction blind. ");
        System.out.println("To win the auction,you must out bid the computer. If you win the auction, the money will be removed from your account.");
        System.out.println("If you do not win the auction, your balance will stay the same and you can enter another auction. ");
        System.out.println("Once you have won an item, it will be stored in your inventory. You can keep a maximum of 5 items at a time.");
        System.out.println("You can either sell the item, for a fixed amount, or you can auction the item you have bought. The amount of money you receive from the auction is not fixed.");
        System.out.println("If your balance goes above 20000 rupees, you have won the game. If your balance goes below 200 rupees, and you have no item in your inventory, you have lost the game. ");
        System.out.println("You will be returned to the menu");
        System.out.println("\n\n");
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

        String itemsbelow500[] = {"x", "Water Bottle", "Phone Case", "Pack of popcorn", "Nail Clipper" , "Fidget Spinner"};
        int costs500[] = {4, 350, 450,50 , 499, 250};
        String itemsbelow1k[] = {"x", "Desk Lamp", "Keyboard", "Book of poems", "Minature Buddha" , "Perfume"};
        int costs1k[] = {4, 660, 750, 699, 999, 450};
        String itemsbw2and5k[] = {"x", "Vinyl CDs", "Autographed Football", "Body length mirror", "Backpack", "Extra Large Lego Set"};
        int costs2k[]= {4, 2250, 2425, 2250, 2499,1500};
        String items5k[] = {"x", "Bluetooth Headphones", "Designer Sunglasses", "Smart Watch", "Miniature Robotics Kit", "Racquetball Kit"};
        int costs5k[] ={4, 2500, 3750, 4500, 4999, 2999};
        String items10k[] = {"x", "Car Tires", "RC Drone", "PSP", "HD Monitor", "Crystal Vase"};
        int costs10k[] ={4, 7999, 6500, 5999, 8750, 9999};

        int random = (int)( Math.random() * 5 + 1);
        if (bal <= 500){
            auctionitem = itemsbelow500[random];
            auctionitemcost = costs500[random];
        }  
        else if (bal>500 && bal <= 2500){
            auctionitem = itemsbelow1k[random];
            auctionitemcost = costs1k[random];
        }  
        else if (bal > 2500 && bal <= 5000){
            auctionitem = items5k[random];
            auctionitemcost = costs5k[random];
        }
        else if (bal >= 5001 && bal <= 10000){
            auctionitem = itemsbw2and5k[random];
            auctionitemcost = costs2k[random];
        }
        else{
            auctionitem = items10k[random];
            auctionitemcost = costs10k[random];
        }
        shuffledauctionitem = shuffle(auctionitem);
        System.out.println("The anagram of the item in auction is '" + shuffledauctionitem + "'\n");
        System.out.println("The item you have won will be revealed to you either after you win the auction or, after you solve the anagram of the name of the item.\n\n");
        boolean flaggg = true;
        while(flaggg == true)
        {

            Scanner sc = new Scanner(System.in);            
            try
            {
                System.out.println("Enter 1 to join the auction blind, or enter 2 to solve the Anagram of the name and the enter the auction.");
                choo = sc.nextInt();
            }
            catch (Exception e)
            {
                sc.nextLine(); 
                System.out.println("Enter only integers");
            }
            finally{
                sc.close();
            }

            if (choo == 1 || choo == 2){
                flaggg = false;
            }

            else{
                System.out.println("Error");
            }
        }

        switch(choo){
            case 1:
            System.out.println("\nYou are entering the auction blind.\n");
            break;
            case 2:
            System.out.println("You will now try to solve the anagram.");
            anagramsolving(shuffledauctionitem, auctionitemcost, auctionitem);
            break;

        }
        double minimumrandom = Math.random();
        int minimumbid = (int)((Math.random()  * auctionitemcost));
        System.out.println("Minimum bid is " + minimumbid + "\n");

        int bid = 0;
        int counterbid = 0 , r;
        int auctionbid = (int)((Math.random() * auctionitemcost) + (Math.random() * (bal - auctionitemcost)));
        int sum = 0;
        while (flag == true)
        {

            System.out.println("Balance is currently " + bal + " rupees.\n");
            /*while(true){
            Scanner sc = new Scanner(System.in);
            try{
            System.out.println("Your current bid is " + bid + ". How much more do you want to bid?.");
            System.out.println("Enter 123456 to leave the auction, or enter your bid now.");
            sum = sc.nextInt();
            }
            catch (Exception e)
            {
            sc.nextLine(); 
            System.out.println("Enter only integers");
            }
            finally{
            sc.close();
            }
            if(sum<=bal || sum == 123456){
            System.out.println(sum);
            break;
            }
            else{
            System.out.println("Error");
            }
            }*/
            while(true){
                Scanner sc = new Scanner(System.in);
                try{
                    System.out.println("Your current bid is " + bid + ". How much more do you want to bid?.");
                    System.out.println("Enter 123456 to leave the auction, or enter your bid now.");
                    sum = sc.nextInt();
                    if(sum<=bal || sum == 123456){
                        System.out.println(sum);
                        break;
                    }
                    else{
                        System.out.println("Error");
                        continue;
                    }

                }
                catch (Exception e)
                {
                    sc.nextLine(); 
                    System.out.println("Enter only integers");
                }
                finally{
                    sc.close();
                }

            }
            if(sum == 123456){
                Menu();
                flag = false;
            }
            else{

                bid += sum;
                if(bid != 0 && bid <= counterbid || bid < minimumbid){
                    System.out.println("Bid cannot be the same as or lower than counterbid. Neither can it be less than the minimum bid. Please try again.");
                    bid -=sum;
                }
                else{
                    System.out.println("Your bid is now " + bid);

                    if (bid > bal){
                        System.out.println("Do not have enough money");
                        bid-=sum;
                        flag = true;
                    }
                    else{
                        if(bid >= auctionbid){
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
                            counterbid = (int)( bid + (Math.random() * (auctionbid - bid)) );
                            if(counterbid == auctionbid){
                                counterbid-=2;
                            }
                            if(counterbid == bid){
                                if (counterbid<auctionbid){
                                    counterbid = counterbid + 1;
                                }
                                System.out.println("You have been outbid by a bid of " + counterbid);

                            }
                            else if (counterbid > bid){
                                System.out.println(" You have been outbid by a bid of " + counterbid);
                                if(counterbid > bal){
                                    System.out.println("This item is too costly for you at this point as you do not have enough balance. ");
                                    System.out.println(" You will be removed from the auction. Please sell something if you can before joining again. ");
                                    flag = false;
                                    Menu();
                                }
                            }

                        }

                    }
                }
            }
        }
    }

    static String shuffle(String auctionitem){
        String shuffledvalue = ""; 
        while (auctionitem.length() != 0)
        {
            int removed = (int) (Math.floor(Math.random() * auctionitem.length()));
            char L = auctionitem.charAt(removed);            
            auctionitem = auctionitem.substring(0,removed)+auctionitem.substring(removed+1);
            shuffledvalue += L;
        }
        return shuffledvalue;
    }

    static void anagramsolving(String y, int c, String b){

        //Scanner sc = new Scanner(System.in);
        System.out.println("\nYou will now begin to try and figure out the name of the item that is being auctioned\n");
        System.out.println("To choose the letter you want place, type it's corresponding number");
        System.out.println("After that, type the position of where you want to place the number\n");
        System.out.println("A few clues:\n");
        System.out.println("Capital letters will always be at the start of words");
        System.out.println("The number of spaces in the shuffled phrase will determine the number of words in the name of the item.");
        System.out.println("Remember, a space is also counted as a character. The spaces have been entered in their correct placed for you.");
        System.out.println("The characters which have been placed have been replaced by a '~'\n");
        String scrne = "", schne = "";
        char j =' ';
        for(int i = 0; i<y.length(); i++){
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
        for (int a = 0; a<y.length();a++){

            int dd = y.charAt(a);

            if((dd <= 90 && dd >= 65)  ||dd == 32){
                System.out.print("~  ");
                qq = '~';
            }
            else{
                System.out.print(y.charAt(a) + "  " );
                qq = y.charAt(a);
            }
            sch+= qq;
        }
        System.out.println();
        System.out.println();
        for(int i = 0; i<y.length(); i++){
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
        for(int i = 0; i<y.length(); i++){
            int cc = b.charAt(i);

            if((cc <= 90 && cc >= 65)  || cc == 32){
                System.out.print(b.charAt(i) + "  ");
                pp  = b.charAt(i);
            }
            else{
                System.out.print("_  ");
                pp = '_';
            }
            scr+=pp;
        }
        System.out.println();
        System.out.println();
        int anac = 0;
        boolean flag1 = true;
        boolean flag3 = true;
        while(flag1 == true){

            while(true){
                Scanner sc = new Scanner(System.in);
                try{
                    System.out.println("Enter 1 for choosing letter from anagram, enter 2 for letter from the solution.");
                    System.out.println("Enter 123456 to stop trying to solve the anagram.\n\n");
                    anac = sc.nextInt();
                }
                catch (Exception e)
                {
                    sc.nextLine(); 
                    System.out.println("Enter only integers");
                }
                finally{
                    sc.close();
                }
                if(anac == 1 || anac == 2 || anac == 123456){
                    break;
                }
                else{
                    System.out.println("Error");
                }
            }

            switch(anac){

                case 1:
                int r = 0;
                while(true){
                    Scanner sc = new Scanner(System.in);
                    try{
                        System.out.println("Enter the corresponding number of the letter you want to move from the anagram");

                        r = sc.nextInt();

                        if(r <= sch.length()){
                            break;
                        }
                        else{
                            System.out.println("Error");
                            continue;
                        }

                    }
                    catch (Exception e)
                    {
                        sc.nextLine(); 
                        System.out.println("Enter only integers");
                    }
                    finally{
                        sc.close();
                    }

                }
                if (sch.charAt(r - 1) == '~'){
                    System.out.println("Character has already been placed.");
                    // || scr.charAt(r - 1) == '_'
                }
                else{

                    int q = 0;
                    while(true){
                        Scanner sc = new Scanner(System.in);
                        try{
                            System.out.println("Enter the corresponding number of the letter you want to move from the anagram");

                            q = sc.nextInt();

                            if(q <= scr.length()){
                                break;
                            }
                            else{
                                System.out.println("Error");
                                continue;
                            }

                        }
                        catch (Exception e)
                        {
                            sc.nextLine(); 
                            System.out.println("Enter only integers");
                        }
                        finally{
                            sc.close();
                        }

                    }
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
                            if(i == (r-1)){
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
                int l = 0;
                while(true){
                    Scanner sc = new Scanner(System.in);
                    try{
                        System.out.println("Enter the corresponding number of the letter you want to move from the solution");

                        l = sc.nextInt();

                        if(l <= scr.length()){
                            break;
                        }
                        else{
                            System.out.println("Error");
                            continue;
                        }

                    }
                    catch (Exception e)
                    {
                        sc.nextLine(); 
                        System.out.println("Enter only integers");
                    }
                    finally{
                        sc.close();
                    }

                }

                if (scr.charAt(l - 1) == '_'){
                    System.out.println("No character is in that position.");
                    // || scr.charAt(r - 1) == '_'
                }
                else{
                    int s = 0;
                    while(true){
                        Scanner sc = new Scanner(System.in);
                        try{
                            System.out.println("Enter the corresponding number of where you want to place the letter ");

                            s = sc.nextInt();

                            if(s <= sch.length()){
                                break;
                            }
                            else{
                                System.out.println("Error");
                                continue;
                            }

                        }
                        catch (Exception e)
                        {
                            sc.nextLine(); 
                            System.out.println("Enter only integers");
                        }
                        finally{
                            sc.close();
                        }

                    }

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
                            if(i == (l-1)){
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
                case 123456:
                flag1 = false;
                flag3 = false;
                break;
                default:
                System.out.println("Error");
                break;
            }
        }

        while(flag3 == true){
            scr = scrne;
            sch = schne;
            schne = "";
            scrne = "";

            if (scr.equals(b) == true){
                System.out.println("You have solved the anagram\n");
                System.out.println("The item was " + scr + "\n");
                int min = (int)(c - (Math.random() * 500));
                int max = (int)(c + (Math.random() * 500));
                System.out.println("The value of the item is " + min + " to " + max + "\n\n");
                flag3 = false;
                //range
            }
            else{

                for(int i = 0; i<y.length(); i++){
                    if (i<9){
                        System.out.print("0"+(i + 1) + " ");
                    }
                    else{
                        System.out.print(i + 1 + " ");
                    }
                }
                System.out.println();
                for (int a = 0; a<y.length();a++){

                    //int dd = sch.charAt(a);

                    //if((dd <= 90 && dd >= 65)  ||dd == 32){
                    // System.out.print("~  ");

                    //}
                    // else{
                    System.out.print(sch.charAt(a) + "  " );

                    // }

                }
                System.out.println();
                System.out.println();
                for(int i = 0; i<y.length(); i++){
                    if (i<9){
                        System.out.print("0"+(i + 1) + " ");
                    }
                    else{
                        System.out.print(i + 1 + " ");
                    }
                }
                System.out.println();

                for(int i = 0; i<y.length(); i++){
                    /*int cc = scr.charAt(i);

                    if((cc <= 90 && cc >= 65)  || cc == 32){
                    System.out.print(scr.charAt(i) + "  ");

                    }
                    else{
                    System.out.print("_  ");

                    }*/
                    System.out.print(scr.charAt(i) + "  ");
                }
                System.out.println();
                System.out.println();

                boolean flag2 = true;
                while(flag2 == true){
                    int anac1 = 0;
                    while(true){
                        Scanner sc = new Scanner(System.in);
                        try{
                            System.out.println("Enter 1 for choosing letter from anagram, enter 2 for letter from the solution");
                            System.out.println("Enter 123456 to stop trying to solve the anagram");
                            anac1 = sc.nextInt();
                        }
                        catch (Exception e)
                        {
                            sc.nextLine(); 
                            System.out.println("Enter only integers");
                        }
                        finally{
                            sc.close();
                        }
                        if(anac1 == 1 || anac1 == 2 || anac1 == 123456){
                            break;
                        }
                        else{
                            System.out.println("Error");
                        }
                    }

                    switch(anac1){
                        case 1: 
                        int r = 0;
                        while(true){
                            Scanner sc = new Scanner(System.in);
                            try{
                                System.out.println("Enter the corresponding number of the letter you want to move from the anagram");

                                r = sc.nextInt();

                                if(r <= sch.length()){
                                    break;
                                }
                                else{
                                    System.out.println("Error");
                                    continue;
                                }

                            }
                            catch (Exception e)
                            {
                                sc.nextLine(); 
                                System.out.println("Enter only integers");
                            }
                            finally{
                                sc.close();
                            }

                        }

                        if (sch.charAt(r - 1) == '~'){
                            System.out.println("Character has already been placed.");
                            // || scr.charAt(r - 1) == '_'
                        }
                        else{
                            int q = 0;
                            while(true){
                                Scanner sc = new Scanner(System.in);
                                try{
                                    System.out.println("Enter the corresponding number of the position you want to place the letter in");
                                    q = sc.nextInt();
                                }
                                catch (Exception e)
                                {
                                    sc.nextLine(); 
                                    System.out.println("Enter only integers");
                                }
                                finally{
                                    sc.close();
                                }
                                if(q <= scr.length()){
                                    break;
                                }
                                else{
                                    System.out.println("Error");
                                }
                            }

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
                                    if(i == (r-1)){
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

                        int l = 0;
                        while(true){
                            Scanner sc = new Scanner(System.in);
                            try{
                                System.out.println("Enter the corresponding number of the letter you want to move from the solution");

                                l = sc.nextInt();
                            }
                            catch (Exception e)
                            {
                                sc.nextLine(); 
                                System.out.println("Enter only integers");
                            }
                            finally{
                                sc.close();
                            }
                            if(l <= scr.length()){
                                break;
                            }
                            else{
                                System.out.println("Error");
                            }
                        }

                        if (scr.charAt(l - 1) == '_'){
                            System.out.println("No character is in that position.");
                            // || scr.charAt(r - 1) == '_'
                        }
                        else{
                            int s = 0;
                            while(true){
                                Scanner sc = new Scanner(System.in);
                                try{
                                    System.out.println("Enter the corresponding number of the position you want to place the letter in");
                                    s = sc.nextInt();
                                }
                                catch (Exception e)
                                {
                                    sc.nextLine(); 
                                    System.out.println("Enter only integers");
                                }
                                finally{
                                    sc.close();
                                }
                                if(s <= sch.length()){
                                    break;
                                }
                                else{
                                    System.out.println("Error");
                                }
                            }

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
                                    if(i == (l-1)){
                                        j = '_';
                                    }
                                    else{
                                        j = scr.charAt(i);
                                    }
                                    scrne+=j;
                                }
                                System.out.println("Letter has been shifted.");

                                flag2 = false;
                            }
                        }
                        break;
                        case 123456:
                        flag3 = false;
                        default:
                        System.out.println("Error");
                        break;
                    }
                }
            }
        }
    }

    static void call_sell_items()
    {

        int sellcount = 0;
        for (int i = 0; i < 5; i ++){

            if(inventory[i] == ""){
                sellcount++;
            }
        }
        if (sellcount == 5){
            System.out.println("You have nothing in your inventory. You will be returned to the menu. PLease buy something from an auction");
            Menu();
        }
        else{
            System.out.println("Welcome to the item selling menu. Over here, you can either sell an item for a fixed amount, or auction an item for a random amount.\n");   
            System.out.println( " The auction has a greater risk as you can lose money, but you can also gain more.\n"); 

            System.out.println( "You currently have in your inventory:"); 
            for (int i = 0; i < 5; i ++){

                System.out.println(i+1 + ")" + inventory[i]);

            }
            int aucbid = 0;
            int liveab = 0;
            boolean eh = true;
            int cs =0;
            while(eh == true){
                /*while(true){
                Scanner sc = new Scanner(System.in);
                try{
                System.out.println("Choose the item you want to sell or auction by choosing it's corresponding number.");
                System.out.println("Or enter 123456 to quit the auction./n");
                cs = sc.nextInt() -1;
                }
                catch(Exception e){
                sc.nextLine();
                System.out.println("Enter only integers");
                }
                finally{
                sc.close();
                }
                if((cs>=0 && cs<5) || cs == 123455){
                break;
                }
                else{
                System.out.println("Error");
                }
                }*/
                while(true){
                    Scanner sc = new Scanner(System.in);
                    try{
                        System.out.println("Choose the item you want to sell or auction by choosing it's corresponding number.");
                        System.out.println("Or enter 123456 to go back to the menu.\n");
                        cs = sc.nextInt() -1;
                        if((cs>=0 && cs<5) || cs == 123455){
                            break;
                        }
                        else{
                            System.out.println("Error");
                            continue;
                        }

                    }
                    catch (Exception e)
                    {
                        sc.nextLine(); 
                        System.out.println("Enter only integers");
                    }
                    finally{
                        sc.close();
                    }

                }

                if (cs == 123455){
                    Menu();
                    eh = false;
                }
                else{
                    String csitem = inventory[cs];
                    int cscost = inventorycost[cs];
                    if (csitem == ""){
                        System.out.println("No item in that slot");
                    }
                    else{

                        int cssp = (int) ((Math.random() * cscost) + (Math.random() * cscost));
                        System.out.println("The price for selling this item at this point in time is " + cssp);
                        System.out.println("You can come back at a later date for a different price, or you can sell the item at this rate now");
                        System.out.println("You can also put this item on the auction block");
                        boolean bool = true;
                        int scl = 0;
                        while (bool == true){
                            while(true){
                                Scanner sc = new Scanner(System.in);
                                try{
                                    System.out.println("Enter 1 for selling, 2 for auction, 3 for coming back later");
                                    scl = sc.nextInt();
                                }
                                catch(Exception e){
                                    sc.nextLine();
                                    System.out.println("Enter only integers");
                                }
                                finally{
                                    sc.close();
                                }
                                if(scl == 1 || scl == 2 || scl == 3){
                                    break;
                                }
                                else{
                                    System.out.println("Error");
                                }
                            }

                            if(scl == 1){
                                inventory[cs] = "";
                                bal += cssp;
                                System.out.println("Item has been sold and your balance is now " + bal + " rupees.");
                                Menu();
                                break;

                            }
                            else if(scl == 2){
                                aucbid = (int)((Math.random() * cscost) + (Math.random() * cscost));

                                System.out.println("The item sold for " + aucbid);
                                inventory[cs] = "";
                                bal += aucbid;
                                System.out.println("Item has been sold and your balance is now " + bal + " rupees.");
                                Menu();
                                break;

                            }
                            else if (scl == 3){
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

                }
            }
        }
    }

    static void call_inventory()
    {
        System.out.println("Welcome to the inventory"); 

        int invcount = 0;
        for (int i = 0; i < 5; i ++){

            if(inventory[i] == ""){
                invcount++;
            }
        }
        if (invcount == 5){
            System.out.println("You have nothing in your inventory. You will be returned to the menu.");
            System.out.println("Your balance is " + bal + " rupees.");
            Menu();
        }

        else{
            System.out.println( "You currently have in your inventory:"); 
            for (int i = 0; i < 5; i ++){

                System.out.println(i+1 + ")" + inventory[i]);

            }
            System.out.println("Your balance is " + bal + " rupees.");
            System.out.println("You will be returned to the menu now");
            Menu();
        }
    }

    static void call_quit()
    {

        System.out.println("Game over. The program is closing now.");             
    }               
}