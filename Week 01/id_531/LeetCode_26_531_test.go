package id531

import "testing"

func Test_remove(t *testing.T) {
	type args struct {
		nums []int
	}
	tests := []struct {
		name string
		args args
		want int
	}{
		{
			name:"removeDuplicates",
			args:args{nums:[]int{1,1,2}},
			want:2,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := removeDuplicates(tt.args.nums); got != tt.want {
				t.Errorf("remove() = %v, want %v", got, tt.want)
			}
		})
	}
}