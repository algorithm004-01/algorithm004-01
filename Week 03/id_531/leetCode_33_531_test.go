package id_531

import "testing"

func TestBFindBreakPoint(t *testing.T) {
	type args struct {
		nums []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{

		{
			name: "test TestBFindBreakPoint",
			args: args{
				nums: []int{10, 11, 12, 14, 1, 2, 3, 4, 5, 6, 7, 8, 9},
			},
			want: 4,
		},
		{
			name: "test TestBFindBreakPoint",
			args: args{
				nums: []int{10, 9},
			},
			want: 1,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := BFindBreakPoint(tt.args.nums); got != tt.want {
				t.Errorf("BFindBreakPoint() = %v, want %v", got, tt.want)
			}
		})
	}
}
