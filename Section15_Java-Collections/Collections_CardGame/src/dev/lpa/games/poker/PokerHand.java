package dev.lpa.games.poker;

import dev.lpa.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokerHand {
    private List<Card> hand;
    private List<Card> keepers;
    private List<Card> discards;
    private Ranking score = Ranking.NONE; //initialize ranking to none
    private int playerNo; //placement from the dealer, p1 next to dealer, dealer is last player

    ///GENERATE A CONSTRUCTOR: playerno and hand
    public PokerHand(int playerNo, List<Card> hand) {
        hand.sort(Card.sortRankReversedSuit()); //sort the hand that was dealt using the comparator created
        this.hand = hand;
        this.playerNo = playerNo;
        keepers = new ArrayList<>(hand.size());
        discards = new ArrayList<>(hand.size());
    }

    ///GENERATE TOSTRING OVERRIDE
    @Override
    public String toString() {
        return "%d. %-16s Rank:%d %-40s Best:%-7s Worst:%-6s %s".formatted(playerNo, score, score.ordinal(), hand,
                Collections.max(hand, Comparator.comparing(Card::rank)),
                Collections.min(hand, Comparator.comparing(Card::rank)),
                (discards.size() > 0 ? "Discards: " + discards : ""));
    }


    ///RANK HANDS
    private void setRank(int faceCount){
        switch(faceCount){
            case 4 -> score = Ranking.FOUR_OF_A_KIND;
            case 3 -> {
                if (score == Ranking.NONE) score = Ranking.THREE_OF_A_KIND;
                else score = Ranking.FULL_HOUSE;
            }
            case 2 -> {
                if (score == Ranking.NONE) score = Ranking.ONE_PAIR;
                else if (score == Ranking.THREE_OF_A_KIND) score = Ranking.FULL_HOUSE;
                else score = Ranking.TWO_PAIR;
            }
        }
    }

    ///EVALUATE PLAYER HANDS
    public void evalHand(){
        //loop through each card in the hand to populate the faceList list with the faceCard attribute
        List<String> faceList = new ArrayList<>(hand.size());
        hand.forEach(card -> faceList.add(card.face()));

        //create another list of face cards where multiples are found
        List<String> duplicateFaceCards = new ArrayList<>();
        faceList.forEach(face -> {
            //check if already contains the face card, add using frequency in collections if not
            if (!duplicateFaceCards.contains(face) && Collections.frequency(faceList, face) > 1){
                duplicateFaceCards.add(face);
            };
        });

        // loop through the list to rank the hand
        for (String duplicate : duplicateFaceCards){
            int start = faceList.indexOf(duplicate);
            int last = faceList.lastIndexOf(duplicate);
            setRank(last - start + 1);
            List<Card> sub = hand.subList(start, last +1);
            keepers.addAll(sub);

        }
        pickDiscards();
    }


    ///DISCARD CARDS METHOD; provides recommended cards to be discarded from the initial deal of cards
    private void pickDiscards(){
        List<Card> temp = new ArrayList<>(hand);
        temp.removeAll(keepers); //remove anything from the temp list that's being kept
        ///dont want to throw away higher ranked cards
        int rankedCards = keepers.size();
        Collections.reverse(temp);
        int index = 0;
        // loop through the cards from the temp list, discard if you don't already have 3 && (if number of ranked Cards is 3+ and I have less than 9)
        for (Card c : temp){
            if (index++ <3 && (rankedCards > 2 || c.rank() < 9)) discards.add(c);
            else keepers.add(c);
        }
    }
}
