class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, List<Integer>> row = new HashMap<>();
        Map<Integer, List<Integer>> column = new HashMap<>();
        int x = 0;
        int y = 0;
        int result = 0;
        for(int i = 0; i < obstacles.length; i++) {
            int tempRow = obstacles[i][0];
            int tempColumn = obstacles[i][1];

            if(tempRow == 0 && tempColumn == 0){
                continue;
            }

            if(!row.containsKey(tempRow)) {
                row.put(tempRow, new ArrayList<>());
            }
            row.get(tempRow).add(tempColumn);

            if(!column.containsKey(tempColumn)) {
                column.put(tempColumn, new ArrayList<>());
            }
            column.get(tempColumn).add(tempRow);
        }

        int direction = 0;
        for(int i = 0 ; i < commands.length; i++) {
            if(commands[i] == -1) {
                direction = (direction + 1) % 4;
            } else if(commands[i] == -2) {
                direction = (direction - 1 + 4) % 4;
            } else {
                int begin = 0;
                int end = 0;
                switch(direction) {
                    case 0:
                        begin = y;
                        end = y += commands[i];
                        if(row.containsKey(x)){
                            int stop = end;
                            for(int k = 0; k < row.get(x).size(); k++){
                                if(row.get(x).get(k) > begin && row.get(x).get(k) <= end){
                                    if(stop >= row.get(x).get(k)){
                                        stop = row.get(x).get(k) - 1;
                                    }
                                }
                            }
                            y = stop;
                        }
                        break;
                    case 1:
                        begin = x;
                        end = x += commands[i];
                        if(column.containsKey(y)){
                            int stop = end;
                            for(int k = 0; k < column.get(y).size(); k++){
                                if(column.get(y).get(k) > begin && column.get(y).get(k) <= end){
                                    if(stop >= column.get(y).get(k)){
                                        stop =  column.get(y).get(k) - 1;
                                    }
                                }
                            }
                            x = stop;
                        }
                        break;
                    case 2:
                        begin = y;
                        end = y -= commands[i];
                        if(row.containsKey(x)){
                            int stop = end;
                            for(int k = 0; k < row.get(x).size(); k++){
                                if(row.get(x).get(k) >= end && row.get(x).get(k) < begin){
                                    if(stop <= row.get(x).get(k)){
                                        stop = row.get(x).get(k) + 1;
                                    }
                                }
                            }
                            y = stop;
                        }
                        break;
                    case 3:
                        begin = x;
                        end = x -= commands[i];
                        if(column.containsKey(y)){
                            int stop = end;
                            for(int k = 0; k < column.get(y).size(); k++){
                                if(column.get(y).get(k) >= end && column.get(y).get(k) < begin){
                                    if(stop <= column.get(y).get(k)){
                                        stop = column.get(y).get(k) + 1;
                                    }
                                }
                            }
                            x = stop;
                        }
                        break;
                }
                
                int tempResult = x * x + y * y;
                if(tempResult > result) {
                    result = tempResult;
                }
            }

            
        }
        return result;
    }
}
