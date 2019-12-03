
type hash map[rune]int

func NewHash() hash {
	hmap := make(hash)
	return hmap
}

func (hm hash) hash(s string) (hs string) {
	for _, a := range s {
		hm[a] += 1
	}
	for i := 0; i < 26; i++ {
		a := rune(97 + i)
		hs += fmt.Sprintf(`%s:%d,`, a, hm[a])
	}
	return hs
}

func groupAnagrams(strs []string) (lres [][]string) {
	res := make(map[string][]string)
	for _, s := range strs {
		hmap := NewHash()
		h := hmap.hash(s)
		res[h] = append(res[h], s)
	}

	for _, s := range res {
		lres = append(lres, s)
	}
	return
}
