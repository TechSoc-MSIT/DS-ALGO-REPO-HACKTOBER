#include<iostream>
#include<cstdlib>

using namespace std;

struct node {
    int info;
    struct node *link;
} *top;


class stack_list {

public:
    node *push(node *, int);

    static node *pop(node *);

    void traverse(node *);

    stack_list()
    {
        top = nullptr;
    }
};

int main()
{
    int choice, item;
    stack_list sl;

    cout << "Operations on Stack" << endl;
    cout << "\n-------------" << endl;
    cout << "1.Push Element into the Stack" << endl;
    cout << "2.Pop Element from the Stack" << endl;
    cout << "3.Traverse the Stack" << endl;
    cout << "4.Quit" << endl;
    while (true)
    {
        cout << "\nEnter your Choice: ";
        cin >> choice;
        switch (choice)
        {
            case 1:
                cout << "Enter value to be pushed into the stack: ";
                cin >> item;
                top = sl.push(top, item);
                break;
            case 2:
                top = sl.pop(top);
                break;
            case 3:
                sl.traverse(top);
                break;
            case 4:
                exit(1);
            default:
                cout << "Wrong Choice" << endl;
        }
    }
}

node *stack_list::push(node *top, int item)
{
    node *tmp;
    tmp = new (struct node);
    tmp->info = item;
    tmp->link = top;
    top = tmp;
    return top;
}

node *stack_list::pop(node *top)
{
    node *tmp;
    if (top == nullptr)
        cout << "Stack is Empty" << endl;
    else
    {
        tmp = top;
        cout << "Element Popped: " << tmp->info << endl;
        top = top->link;
        free(tmp);
    }
    return top;
}

void stack_list::traverse(node *top)
{
    node *ptr;
    ptr = top;
    if (top == nullptr)
        cout << "Stack is empty" << endl;
    else
    {
        cout << "Stack elements :" << endl;
        while (ptr != nullptr)
        {
            cout << ptr->info << endl;
            ptr = ptr->link;
        }
    }
}