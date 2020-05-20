/*
* File:   CErrors.h
* Author: Антонов Ю.С.
*
* Created on 25 Сентябрь 2012 г., 19:43

*Класс CError предназначен для хранения информации об ошибке,
*ее коде, методе и объекте вызвавшем данную ошибку
*предназначен для использования с try catch throw
*/
#ifndef CERRORS_H
#define CERRORS_H

#include<string>
#include<iostream>
using namespace std;

class CError
{
protected:
	int ErrorCode;
	string ErrorDescription;
	string ErrorInitObject;
	string ErrorInitMethod;
public:
    CError()
    {
        ErrorCode=0;
    };

    CError(string Description="Undefined", int Code=0,string Method="Undefined", string ErrObject="Undefined")
	  {
		  ErrorDescription=Description;
		  ErrorCode=Code;
		  ErrorInitMethod=Method;
		  ErrorInitObject=ErrObject;
	  };
    string SpellError()
	  {
		  return "\nError ocured!\n"+ErrorInitMethod+" generate error in"+ErrorInitObject+" object"+"\nErrorDescription: "+ErrorDescription;
	  };
};
#endif

