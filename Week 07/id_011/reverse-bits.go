package algorithm00401

func reverseBits(num uint32) uint32 {
	bits, count := uint32(0), uint32(0)
	for count > 0 {
		bits |= (nums & 1) << (count - 1)
		num >>= 1
		count--
	}
	return bits
}
