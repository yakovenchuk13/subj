#include <iostream>
#include <mem.h>
#include "CVector.h"

using namespace std;

int main(int argc, char* argv[])
{
    CVector <double> v1(5),v2(4),v3;
    cout<<endl;
      try
	{
    cin>>v1>>v2;
    v3=v2+v1;
    cout << endl << "Mult vect to const: " << v2;
    cout << "\n Vector is:: \n1." << v1<< "\n2. " <<v2 << " \n3. "<<v3<<endl;
	}

	catch(CError &e)
	{
		cout<<e.SpellError();
		return 403;
	}
	catch(...)
	{
	    cout<<"\n400 Bad Request!!!\n";
	    return 400;
	}
    return 0;
}
