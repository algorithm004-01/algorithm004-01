using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApp
{
    public class MyCircularDeque
    {
        private readonly List<int> _queue;
        private readonly int _length;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k)
        {
            _length = k;
            _queue = new List<int>(_length);
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public bool InsertFront(int value)
        {
            if (IsFull())
            {
                return false;
            }
            else
            {
                _queue.Insert(0, value);
                return true;
            }
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public bool InsertLast(int value)
        {
            if (IsFull())
            {
                return false;
            }
            else
            {
                _queue.Add(value);
                return true;
            }
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public bool DeleteFront()
        {
            if (IsEmpty())
            {
                return false;
            }
            else
            {
                _queue.RemoveAt(0);
                return true;
            }
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public bool DeleteLast()
        {
            if (IsEmpty())
            {
                return false;
            }
            else
            {
                _queue.RemoveAt(_queue.Count - 1);
                return true;
            }
        }

        /** Get the front item from the deque. */
        public int GetFront() => IsEmpty() ? -1 : _queue.First();

        /** Get the last item from the deque. */
        public int GetRear() => IsEmpty() ? -1 : _queue.Last();

        /** Checks whether the circular deque is empty or not. */
        public bool IsEmpty() => _queue == null || _queue.Count == 0;

        /** Checks whether the circular deque is full or not. */
        public bool IsFull() => _queue != null && _queue.Count == _length;
    }

    /**
    * Your MyCircularDeque object will be instantiated and called as such:
    * MyCircularDeque obj = new MyCircularDeque(k);
    * bool param_1 = obj.InsertFront(value);
    * bool param_2 = obj.InsertLast(value);
    * bool param_3 = obj.DeleteFront();
    * bool param_4 = obj.DeleteLast();
    * int param_5 = obj.GetFront();
    * int param_6 = obj.GetRear();
    * bool param_7 = obj.IsEmpty();
    * bool param_8 = obj.IsFull();
    */
}
