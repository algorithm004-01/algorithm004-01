func isAnagram(s string, t string) bool {
    if len(s) != len(t) {
        return false
	}
	
    counter := map[byte]int{}
    
    for i := 0; i < len(s); i++ {
        counter[s[i]]++
        counter[t[i]]--
    }
    
    for _, r := range counter {
        if r >= 1 {
            return false
        }
    }
    
    return true
}