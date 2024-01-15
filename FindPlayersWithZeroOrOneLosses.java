class FindPlayersWithZeroOrOneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> matchLostMp = new TreeMap<>();
        for(var match : matches){
           int winner = match[0], looser = match[1];
           matchLostMp.put(winner, matchLostMp.getOrDefault(winner, 0));
           matchLostMp.put(looser, matchLostMp.getOrDefault(looser, 0)-1);
        }
        List<Integer> winners = new ArrayList<>(), loosers = new ArrayList<>();
        for(var lostMatchEntry : matchLostMp.entrySet()){
            int lostCnt = lostMatchEntry.getValue(), player = lostMatchEntry.getKey();
            if(lostCnt == 0){
                winners.add(player);
            }else if(lostCnt == -1){
                loosers.add(player);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(winners);
        res.add(loosers);
        return res;
    }
}
