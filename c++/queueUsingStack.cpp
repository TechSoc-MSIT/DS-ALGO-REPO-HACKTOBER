// Submitted by SHUBHAM AGGARWAL (https://github.com/Shubham0324)
//  Simplified C++ code for Queue Using Stack


#include<iostream>
using namespace std;

void push1(int);
void push2(int);
int pop1();
int pop2();
void enqueue();
void display();
void create();

int st1[100], st2[100];
int top1 = -1, top2 = -1;
int count = 0;

int main()
{
    int ch;

    cout<<"1-enter element into queue ";
    cout<<"\n2-display elements ";
    cout<<"\n3-exit from execution";
    create();
    while (true)
    {
        cout<<"\n\nenter your choice :";
        cin>>ch;

        switch (ch)
        {
            case 1:
                enqueue();
                break;
            case 2:
                display();
                break;
            case 3:
                exit(0);
            default:
                cout<<"wrong choice";
        }
    }
}

void create()
{
    top1 = top2 = -1;
}

void push1(int data)
{
    st1[++top1] = data;
}

int pop1()
{
    return(st1[top1--]);
}

void push2(int data)
{
    st2[++top2] = data;
}


int pop2()
{
    return(st2[top2--]);
}

void enqueue()
{
    int data, i;

    cout<<"Enter data into queue :";
    cin>>data;
    push1(data);
    count++;
}


void display()
{
    int i;

    for (i = 0;i <= top1;i++)
    {
        cout<<st1[i]<<"\t";

    }
}