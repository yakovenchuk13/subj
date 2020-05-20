#ifndef CVECTOR_H
#define CVECTOR_H

#include <iostream>
#include <mem.h>
#include "CErrors.h"

using namespace std;
typedef unsigned long long int UInt64;

template <typename T>
class CVector
{
    protected:
       T *Data;
       int VectorSize;
    public:
        CVector(UInt64 vsize=0){
            Data=new T[vsize];
            VectorSize=vsize;
            cout<<"\nConstruct Def ptr="<<Data;
        };
        CVector(UInt64 NewSize){
            Data=new T[NewSize];
            VectorSize=NewSize;
            cout<<"\nConstruct Standart ptr="<<Data;
        };
         CVector(CVector &v);
          CVector(CVector &&v);
          void operator=(const CVector &copy);
          CVector operator+(CVector &);
          T operator*(CVector&);
          CVector operator*=(UInt64 &);
          UInt64 GetNum(UInt64&);
          void SetNum(UInt64&,T&);

        virtual ~CVector(){
            cout<<"\nDestroy "<<Data;
            delete []Data;
            VectorSize=0;
        };

CVector(CVector &v)
{
   *this=v;
   cout<<"\nConstruct Def ptr="<<Data;
}
 CVector(CVector &&v)
{
   Data=v.Data;
   v.Data=nullptr;
   VectorSize=v.VectorSize;
   v.VectorSize=0;
   cout<<"\nConstruct Move ptr="<<Data;
}

void operator=(const CVector &copy)
{
  cout<<"\nOperator =";
  if(this==&copy)
    return;
  delete []Data;
  if(nullptr==copy.Data)
    {
        Data=nullptr;
        VectorSize=0;
        return;
    }
  Data=new T [copy.VectorSize];
  cout<<" ptr= "<<Data << endl;
  VectorSize=copy.VectorSize;
  memcpy(Data,copy.Data,sizeof(copy.Data));
  return;
}

CVector  operator+(CVector &v2)
{

	if(VectorSize != v2.VectorSize)
		throw CError("Different size of vectors!!!",1,"Add");
    CVector tmp=v2;
    for(UInt64 i=0;i<VectorSize;i++)
      tmp.Data[i]+=Data[i];
    return tmp;
}

CVector  operator*=(UInt64& a)
{
    UInt64 tmp64 = a;
    CVector tmp = *this;
   for(UInt64 i=0;i<VectorSize;i++)
      Data[i]*=tmp64;
   return tmp;
}

T  operator*(CVector& V)
{
	if(VectorSize != V.VectorSize)
		throw CError("Different size of vectors!!!",1,"Mult");
    T sum=0;
    for(UInt64 i=0;i<VectorSize;i++)
      sum +=Data[i]* V.Data[i];
    return sum;
}

UInt64  GetNum(UInt64& search)
{
	if(search > VectorSize)
		throw CError("Different size of vectors!!!",1,"search");
    for(UInt64 i=0;i<VectorSize;i++)
      {
          if(i == search)
          return Data[i];
      }

    cout << "\nitem not found(search)!!!\n";
    return 0;
}

void  SetNum(UInt64& search, T& get)
{
	if(search > VectorSize)
		throw CError("Different size of vectors!!!",1,"set_num");
	for(UInt64 i=0;i<VectorSize;i++)
      {
          if(i == search){
              Data[i]=get;
              cout << "\n ELEment numb " << search << "get to array" << endl;
              return;
          }
      }

    cout << "NO elem!\n";
    return;
}

friend ostream& operator<< (ostream& stream,CVector &V)
{
   stream<<"\nVector["<<V.VectorSize<<"] at "<<V.Data<<"=";
   for(int i=0;i<V.VectorSize;i++)
      stream<<V.Data[i]<<' ';
   return stream;
}

friend istream& operator>> (istream& stream,CVector &V)
{
    for(int i=0;i<V.VectorSize;i++)
      stream>>V.Data[i];
    return stream;
}
};

#endif // CVECTOR_H
