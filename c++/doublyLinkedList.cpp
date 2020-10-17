#include<iostream>
#include<cstdlib>
using namespace std;

// Node Declaration
struct node
{
    int info;
    struct node *next;
    struct node *prev;
}*start;

class double_llist
{
public:
    static void create_list(int value);
    void add_begin(int value);
    static void add_after(int value, int position);
    void delete_element(int value);
    void search_element(int value);
    static void display_dlist();
    void count();
    void reverse();
    double_llist()
    {
        start = nullptr;
    }
};

int main()
{
    int choice, element, position;
    double_llist dl;

    cout<<endl<<"Operations on Doubly linked list"<<endl;
    cout<<"1.Create Node"<<endl;
    cout<<"2.Add at begining"<<endl;
    cout<<"3.Add after position"<<endl;
    cout<<"4.Delete"<<endl;
    cout<<"5.Display"<<endl;
    cout<<"6.Count"<<endl;
    cout<<"7.Reverse"<<endl;
    cout<<"8.Quit"<<endl;
    while (true)
    {
        cout<<"Enter your choice : ";
        cin>>choice;
        switch ( choice )
        {
            case 1:
                cout<<"Enter the element: ";
                cin>>element;
                double_llist::create_list(element);
                cout<<endl;
                break;
            case 2:
                cout<<"Enter the element: ";
                cin>>element;
                dl.add_begin(element);
                cout<<endl;
                break;
            case 3:
                cout<<"Enter the element: ";
                cin>>element;
                cout<<"Insert Element after postion: ";
                cin>>position;
                dl.add_after(element, position);
                cout<<endl;
                break;
            case 4:
                if (start == nullptr)
                {
                    cout<<"List empty,nothing to delete"<<endl;
                    break;
                }
                cout<<"Enter the element for deletion: ";
                cin>>element;
                dl.delete_element(element);
                cout<<endl;
                break;
            case 5:
                dl.display_dlist();
                cout<<endl;
                break;
            case 6:
                dl.count();
                break;
            case 7:
                if (start == nullptr)
                {
                    cout<<"List empty,nothing to reverse"<<endl;
                    break;
                }
                dl.reverse();
                cout<<endl;
                break;
            case 8:
                exit(1);
            default:
                cout<<"Wrong choice"<<endl;
        }
    }
    return 0;
}

void double_llist::create_list(int value)
{
    struct node *s, *temp;
    temp = new(struct node);
    temp->info = value;
    temp->next = nullptr;
    if (start == nullptr)
    {
        temp->prev = nullptr;
        start = temp;
    }
    else
    {
        s = start;
        while (s->next != nullptr)
            s = s->next;
        s->next = temp;
        temp->prev = s;
    }
}

void double_llist::add_begin(int value)
{
    if (start == nullptr)
    {
        cout<<"First Create the list."<<endl;
        return;
    }
    struct node *temp;
    temp = new(struct node);
    temp->prev = nullptr;
    temp->info = value;
    temp->next = start;
    start->prev = temp;
    start = temp;
    cout<<"Element Inserted"<<endl;
}

void double_llist::add_after(int value, int pos)
{
    if (start == nullptr)
    {
        cout<<"First Create the list."<<endl;
        return;
    }
    struct node *tmp, *q;
    int i;
    q = start;
    for (i = 0;i < pos - 1;i++)
    {
        q = q->next;
        if (q == nullptr)
        {
            cout<<"There are less than ";
            cout<<pos<<" elements."<<endl;
            return;
        }
    }
    tmp = new(struct node);
    tmp->info = value;
    if (q->next == nullptr)
    {
        q->next = tmp;
        tmp->next = nullptr;
        tmp->prev = q;
    }
    else
    {
        tmp->next = q->next;
        tmp->next->prev = tmp;
        q->next = tmp;
        tmp->prev = q;
    }
    cout<<"Element Inserted"<<endl;
}

void double_llist::delete_element(int value)
{
    struct node *tmp, *q;
    if (start->info == value)
    {
        tmp = start;
        start = start->next;
        start->prev = nullptr;
        cout<<"Element Deleted"<<endl;
        free(tmp);
        return;
    }
    q = start;
    while (q->next->next != nullptr)
    {
        if (q->next->info == value)
        {
            tmp = q->next;
            q->next = tmp->next;
            tmp->next->prev = q;
            cout<<"Element Deleted"<<endl;
            free(tmp);
            return;
        }
        q = q->next;
    }
    if (q->next->info == value)
    {
        tmp = q->next;
        free(tmp);
        q->next = nullptr;
        cout<<"Element Deleted"<<endl;
        return;
    }
    cout<<"Element "<<value<<" not found"<<endl;
}

void double_llist::display_dlist()
{
    struct node *q;
    if (start == nullptr)
    {
        cout<<"List empty,nothing to display"<<endl;
        return;
    }
    q = start;
    cout<<"The Doubly Link List is :"<<endl;
    while (q != nullptr)
    {
        cout<<q->info<<" <-> ";
        q = q->next;
    }
    cout<<"NULL"<<endl;
}

void double_llist::count()
{
    struct node *q = start;
    int cnt = 0;
    while (q != nullptr)
    {
        q = q->next;
        cnt++;
    }
    cout<<"Number of elements are: "<<cnt<<endl;
}

void double_llist::reverse()
{
    struct node *p1, *p2;
    p1 = start;
    p2 = p1->next;
    p1->next = nullptr;
    p1->prev = p2;
    while (p2 != nullptr)
    {
        p2->prev = p2->next;
        p2->next = p1;
        p1 = p2;
        p2 = p2->prev;
    }
    start = p1;
    cout<<"List Reversed"<<endl;
}