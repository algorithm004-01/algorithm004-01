var minDistance = function (word1, word2) {
    let D = [];
    for (let i = 0; i <= word1.length; i++) {
        if (D[i] === undefined) {
            D[i] = [];
        }
        for (let j = 0; j <= word2.length; j++) {
            if (i === 0) {
                D[i][j] = j;

            } else if (j === 0) {
                D[i][j] = i;
            } else if (word1[i - 1] === word2[j - 1]) {
                D[i][j] = D[i-1][j-1];
            } else {
                D[i][j] = Math.min(D[i - 1][j] + 1, D[i][j - 1] + 1, D[i-1][j - 1] + 1);
            }
        }
    }
    return D[word1.length][word2.length]
};