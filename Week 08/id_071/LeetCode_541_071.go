package week08

// 2.3 https://leetcode-cn.com/problems/reverse-string-ii/
func reverseStr(s string, k int) string {

	res := []byte(s)
	for i := 0; i < len(s); i = i + 2*k {
		if i + k < len(res){
			reverse(res[i : i+k])
		}else{
			reverse(res[i:])
		}
	}
	return string(res)
}

func reverse(b []byte){
	l, r := 0, len(b) - 1
	for l < r {
		b[l], b[r] = b[r], b[l]
		l, r = l+1, r+1
	}
}