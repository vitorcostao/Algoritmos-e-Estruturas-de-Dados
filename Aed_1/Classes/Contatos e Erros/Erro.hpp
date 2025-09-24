#ifndef ERRO_HPP
#define ERRO_HPP

/**

 1) Implementacao de classe de Erros para uso posterior

*/


class Erro{


    ///Privados
    private:

        int erro;


    ///Protegidos
    protected:

        void setErro(int codigo){

            erro = codigo;
        }


    ///Publicos
    public:

        ~Erro(){}

        Erro(){

            erro = 0;
        }

        int getErro(){

            return erro;
        }

        bool hasErro(){

            return getErro() != 0;
        }

};


#endif // ERRO_HPP
