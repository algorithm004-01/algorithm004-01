

//只有小写英文字母
//长度[1, 10000]

func reverseStr(s string, k int) string {
	var strBytes = []byte(s)
	var sLen = len(strBytes)

	var reverseInPlace = func(i int, j int) {
		for i < j {
			strBytes[i], strBytes[j] = strBytes[j], strBytes[i]
			i++
			j--
		}
	}

	i := 0
	for sLen >= 2 * k {
		reverseInPlace(i, i + k - 1)
		i += 2 * k
		sLen -= 2 * k
	}

	if sLen < k {
		reverseInPlace(i, len(strBytes) - 1)
	} else if sLen < 2 * k {
		reverseInPlace(i, i + k - 1)
	}
	return string(strBytes)
}