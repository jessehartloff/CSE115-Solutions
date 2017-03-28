import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * There is no intra-day trading in this assignment. All prices given are the price at the close of trading for
 * each day. We will assume all trades for a given day are made at this price.
 * <p>
 * Stock prices obtained from Yahoo Finance.
 */
public class Investing {


    static HashMap<String, Double> getPrices(String filename) {
        HashMap<String, Double> prices = new HashMap<String, Double>();
        try {
            for (String line : Files.readAllLines(Paths.get(filename))) {
                String[] splits = line.split(",");
                prices.put(splits[0], new Double(splits[1]));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prices;
    }


    /**
     * 5 points
     * <p>
     * Return the price of the stock at the given date as a double
     *
     * @param stockFileName
     * @param date
     * @return
     */
    public static double getPrice(String stockFileName, String date) {
        HashMap<String, Double> prices = getPrices(stockFileName);

        return prices.get(date);
    }


    /**
     * 5 points
     * <p>
     * Return the cost of a single trade (stock price times number of shares).
     * If the trader is selling the shares this number should be negative.
     *
     * @param stockFileName
     * @param date
     * @param buyOrSell      Equals either "buy" or "sell" indicating the direction of the trade
     * @param numberOfShares
     * @return
     */
    public static double costOfTrade(String stockFileName, String date, String buyOrSell, int numberOfShares) {

        return numberOfShares * (buyOrSell.equals("buy") ? getPrice(stockFileName, date) : -getPrice(stockFileName, date));
    }


    /**
     * 10 points
     * <p>
     * Determine whether or not the given trader made all valid trades. The file for a trader contains the details
     * of all trades throughout the year in chronological order with one trade on each line in the
     * format "date,buyOrSell,numberOfShares,tickerSymbol" (ex. "2012-05-18,buy,100,GOOG"). Each trader is given a
     * certain amount of starting cash and their cash will fluctuate throughout the year of trading. A trade is
     * invalid if any of the following are true:
     * <p>
     * 1. The trader buys more shares of a stock than can be afforded with their current cash
     * 2. The trader sells more shares of a stock than they own
     * 3. The date of the trade was not a valid trading day, or not a date in 2016 (any day not in the given files)
     * 4. There is no data for the ticker symbol of the trade (not AAPL, GOOG, or MSFT)
     *
     * @param traderFileName  The name of a file containing all the trades made by a trader throughout the year
     * @param startingCash    The amount of cash the trader has available at the start of the year
     * @param tickerFilenames Maps ticker symbols to the stock's filename
     * @return true if all trades are valid, false otherwise
     */
    public static boolean isTradingValid(String traderFileName, double startingCash,
                                         HashMap<String, String> tickerFilenames) {
        double cash = startingCash;

        HashMap<String, Integer> sharesOwned = new HashMap<>();
        for (String ticker : tickerFilenames.keySet()) {
            sharesOwned.put(ticker, 0);
        }

        try {
            for (String line : Files.readAllLines(Paths.get(traderFileName))) {
                String[] splits = line.split(",");
                String date = splits[0];
                String buyOrSell = splits[1];
                int numberOfShares = new Integer(splits[2]);
                String ticker = splits[3];
                sharesOwned.put(ticker, sharesOwned.get(ticker) + (buyOrSell.equals("buy") ? numberOfShares : -numberOfShares));
                if(sharesOwned.get(ticker) < 0){
                    return false;
                }
                cash -= costOfTrade(tickerFilenames.get(ticker),date,buyOrSell,numberOfShares);
                if(cash < 0.0){
                    return false;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }


    /**
     * 10 points
     * <p>
     * Compute the ROI of a given trader with a given starting cash.
     * Compute ROI as a fraction, as opposed to a percentage.
     * ROI is computed with the change in cash over the year and the value of all owned stocks.
     * The value of an owned stock is computed by it's price on the last trading day of the year ("2016-12-30").
     * You can assume all traders start the year owning no shares of any stock.
     * <p>
     * Examples:
     * If a trader started with $1000 and ended the year with $1100 and $100 worth of stocks their ROI is 0.2
     * If a trader started with $8000 and ended the year with $6000 and $1500 worth of stocks, their ROI is -0.0625
     * <p>
     * If the trader makes any invalid trades, return 0.0;
     *
     * @param traderFileName
     * @param startingCash
     * @param tickerFilenames Maps ticker symbols to the stock's filename
     * @return
     */
    public static double getTraderROI(String traderFileName, double startingCash,
                                      HashMap<String, String> tickerFilenames) {

        double cash = startingCash;

        if(!isTradingValid(traderFileName,startingCash,tickerFilenames)){
            return 0.0;
        }

        HashMap<String, Integer> sharesOwned = new HashMap<>();
        for (String ticker : tickerFilenames.keySet()) {
            sharesOwned.put(ticker, 0);
        }

        try {
            for (String line : Files.readAllLines(Paths.get(traderFileName))) {
                String[] splits = line.split(",");
                String date = splits[0];
                String buyOrSell = splits[1];
                int numberOfShares = new Integer(splits[2]);
                String ticker = splits[3];
                sharesOwned.put(ticker, sharesOwned.get(ticker) + (buyOrSell.equals("buy") ? numberOfShares : -numberOfShares));
                cash -= costOfTrade(tickerFilenames.get(ticker),date,buyOrSell,numberOfShares);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return 0.0;
        }

        String endDate = "2016-12-30";
        double equity = cash;
        for(String tickerOwned : sharesOwned.keySet()){
            equity += getPrice(tickerFilenames.get(tickerOwned),endDate) * sharesOwned.get(tickerOwned);
        }

        return (equity - startingCash)/startingCash;

        
    }


    /**
     * 10 points
     * <p>
     * Compute the ROI of the firm.
     * <p>
     * Compute the total ROI given a map of traders and their starting cash
     * Note: Total ROI is not the average of each individual ROI. The total gain/loss of each trader must be considered
     * Example:
     * A trader starting with $5 and an ROI of 2.0 made $15. Another trader with $200 and ROI of -0.5 lost $100.
     * The average ROI is 1.25, but the total cash went from $205 to $120 for a total ROI of -0.4146
     *
     * @param traderFileNamesAndStartingCash
     * @param tickerFilenames                Maps ticker symbols to the stock's filename
     * @return
     */
    public static double getTotalROI(HashMap<String, Double> traderFileNamesAndStartingCash,
                                     HashMap<String, String> tickerFilenames) {

        double totalStartingCash = 0;
        double totalEndingEquity = 0;

        for(String traderFile : traderFileNamesAndStartingCash.keySet()){
            double startingCash = traderFileNamesAndStartingCash.get(traderFile);
            totalStartingCash += startingCash;
            totalEndingEquity += startingCash*(1.0+getTraderROI(traderFile, startingCash, tickerFilenames));
        }

        return (totalEndingEquity - totalStartingCash)/totalStartingCash;
    }

    
    
    
    
    
    public static String tradeToString(String date, String buyOrSell, int numberOfShares, String ticker){
        return date + "," + buyOrSell + "," + numberOfShares + "," + ticker;
    }

    
    
    public static void writeTrades(String outputFilename, ArrayList<String> trades){
        String toWrite = "";
        for(String trade : trades){
            toWrite += trade + "\n";
        }
        try {
            Files.write(Paths.get(outputFilename), toWrite.getBytes());
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Challenge Question
     * Bonus: 10 points
     * <p>
     * Historical Algorithmic Trader: Create a sheet of trades to maximize ROI given x starting capital.
     *
     * @param outputFilename
     * @param startingCash
     * @param tickerFilenames Maps ticker symbols to the stock's filename
     */
    public static void historicalAlgorithmicTrader(String outputFilename, double startingCash,
                                                   HashMap<String, String> tickerFilenames) {

        // Compute the optimal trading that would maximize ROI over the year with the given starting cash. You must
        // never buy more shares of a stock than you can afford or the trade is invalid. If you buy and sell shares on
        // the same day you can assume all the sells are executed before any of the buys. Write all trades to the
        // output file in the same format as the given trading files.
        //
        // Your algorithm must work for any stocks given in tickerFilenames which won't necessarily be the three used
        // for the assignment. You can assume the trading days will be the same (all of 2016).
        //
        // Points are all-or-nothing. Even a single penny short of optimal trading will result in 0 points.
        //
        // Note: This is a true challenge!

        if(tickerFilenames.isEmpty()){
            // later code assumes at least 1 ticker is provided.
            return;
        }


        HashMap<String, HashMap<String, Double>> allPrices = new HashMap<>();
        ArrayList<String> allTradingDays = new ArrayList<>();

        for(String ticker : tickerFilenames.keySet()){
            allPrices.put(ticker, getPrices(tickerFilenames.get(ticker)));
            if(allTradingDays.isEmpty()){
                allTradingDays.addAll(allPrices.get(ticker).keySet());
                Collections.sort(allTradingDays);
            }
        }


        ArrayList<String> trades = new ArrayList<>();

        // -sort the stocks by percentage change from today to tomorrow
        // -sell everything
        // -buy as many of the biggest winner as you can afford. Then buy the most of the second you can afford, etc
        //  until you reach a losing stock
        // --If they're all losers, don't buy (tomorrow is a better day to buy)
        //

        HashMap<String, Integer> sharesOwned = new HashMap<>();
        for(String ticker : allPrices.keySet()){
            sharesOwned.put(ticker, 0);
        }

        double cash = startingCash;

        // loop through all but the last trading day. No trades on the last day will change the roi
        for (int dayIndex = 0; dayIndex < allTradingDays.size()-1; dayIndex++) {
            String today = allTradingDays.get(dayIndex);
            String tomorrow = allTradingDays.get(dayIndex+1);

            for(String ticker : sharesOwned.keySet()){
                int shares = sharesOwned.get(ticker);
                if(shares != 0){
                    trades.add(tradeToString(today, "sell", shares, ticker));
                    cash -= costOfTrade(tickerFilenames.get(ticker),today,"sell",shares);
                    sharesOwned.put(ticker, 0);
                }
            }

            // sorting best stocks can be done simpler with a PriorityQueue, but I'll stick
            // with what's been covered in class
            HashMap<String, Double> percentageGain = new HashMap<>();
            for(String ticker : allPrices.keySet()){
                double priceToday = allPrices.get(ticker).get(today);
                double priceTomorrow = allPrices.get(ticker).get(tomorrow);
                double gain = (priceTomorrow-priceToday)/priceToday;
                if(gain > 0) {
                    percentageGain.put(ticker, gain);
                }
            }

            while(!percentageGain.isEmpty()){
                String bestTicker = "";
                double highestGain = 0.0;
                for(String ticker : percentageGain.keySet()){
                    if(percentageGain.get(ticker) > highestGain){
                        highestGain = percentageGain.get(ticker);
                        bestTicker = ticker;
                    }
                }

                // buy the best
                double purchasePrice = allPrices.get(bestTicker).get(today);
                int shares = (int) (cash/purchasePrice);
                if(shares != 0) {
                    trades.add(tradeToString(today, "buy", shares, bestTicker));
                    cash -= costOfTrade(tickerFilenames.get(bestTicker), today, "buy", shares);
                    sharesOwned.put(bestTicker, shares); // assumes we own no shares
                }

                percentageGain.remove(bestTicker);
            }

        }


        writeTrades(outputFilename, trades);

    }


    // The following testing code is to provided to help you get started testing your code. Provided are
    // methods to test getPrice and getTradePrice along with sample calls to test getPrice.
    //
    // *You are encouraged to write similar testing code for the rest of the assignment

    public static void testGetPrice(String priceFile, String date, double confirmedPrice) {
        double computedPrice = getPrice(priceFile, date);
        System.out.println("getPrice(\"" + priceFile + "\", \"" + date + "\") returned : " + computedPrice);
        System.out.println("Confirmed price: " + confirmedPrice + "\n");
    }

    public static void testGetTradePrice(String priceFile, String date, String buyOrSell, int numberOfShares, double confirmedPrice) {
        double computedPrice = costOfTrade(priceFile, date, buyOrSell, numberOfShares);
        System.out.println("getPrice(\"" + priceFile + "\", \"" + date + "\", \"" + buyOrSell + "\", " + numberOfShares + ") returned : " + computedPrice);
        System.out.println("Confirmed price: " + confirmedPrice + "\n");
    }

    public static void main(String[] args) {

        String priceFile = "historicPrices/AAPL_2016.csv";
        String date = "2016-03-04";
        double confirmedPrice = 103.010002;
        testGetPrice(priceFile, date, confirmedPrice);

        priceFile = "historicPrices/GOOG_2016.csv";
        date = "2016-01-04";
        confirmedPrice = 741.840027;
        testGetPrice(priceFile, date, confirmedPrice);

        priceFile = "historicPrices/GOOG_2016.csv";
        date = "2016-03-09";
        confirmedPrice = 705.23999;
        testGetPrice(priceFile, date, confirmedPrice);

        System.out.println("If the price in the file and computed price do not match, please check your code in the " +
                "getPrice function.\nIf you are struggling, come to office hours. We are waiting for your " +
                "questions and are always happy to help.");
    }


}
