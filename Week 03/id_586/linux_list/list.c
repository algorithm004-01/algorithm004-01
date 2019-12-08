#include <linux/kernel.h>
#include <linux/module.h>
#include <linux/slab.h>
#include <linux/list.h>

#define N	8	/* 链表节点 */

struct book_list {
	int id;			/* 数据 */
	struct list_head list;	/* 指向双联表前后节点的指针 */
};

struct book_list book_head; /* 头节点 */

static int __init list_test_init(void)
{
	struct book_list *node;	/* 每次申请链表节点时所用的指针 */
	struct list_head *pos;
	struct book_list *p;
	int i;

	printk("%s is starting...\n", __func__);
	INIT_LIST_HEAD(&book_head.list);

	/* 建立N个节点，依次加入到链表当中 */
	for (i = 0; i < N; i++) {
		/* kmalloc（）在内核空间申请内存，类似于malloc,参见第四章 */
		node = (struct book_list *)kmalloc(sizeof(struct book_list), GFP_KERNEL); 
		node->id = i+1;
		list_add_tail(&node->list, &book_head.list);
		printk("Node %d has added to the list_test...\n", i+1);
	}

	/* 遍历链表 */
	i = 1;
	list_for_each(pos, &book_head.list) {
		p = list_entry(pos, struct book_list, list);
		printk("Node %d's data:%d\n", i, p->id);
		i++;
	}

	return 0;
}

static void __exit list_test_exit(void)
{
	struct list_head *pos, *n;
	struct book_list *p;
	int i = 1;

	/* 依次删除N个节点, 为了安全删除节点而进行的遍历 */
	list_for_each_safe(pos, n, &book_head.list) {
		list_del(pos);
		p = list_entry(pos, struct book_list, list);
		kfree(p);
		printk("Node %d has removed from the list_test...\n", i++);
	}
	printk("%s is exiting...\n", __func__);
}

module_init(list_test_init);
module_exit(list_test_exit);

MODULE_LICENSE("GPL");
MODULE_AUTHOR("TEST");
