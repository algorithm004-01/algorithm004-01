obj-m  := list.o
KDIR	:= /lib/modules/`uname -r`/build

all:
	make -C $(KDIR) M=$$PWD

clean:
	make -C $(KDIR) M=$$PWD clean

