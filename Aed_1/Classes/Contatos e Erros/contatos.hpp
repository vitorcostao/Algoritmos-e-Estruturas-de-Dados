#ifndef CONTATOS_HPP
#define CONTATOS_HPP

/**

 1) Implementacao de classe para tratar contatos derivados de erros

 Codigo de erro:

 -  0: Nao tem erros
 -  1: Nome ou fone vazio(s)
 -  2: Fone com letras ou simbolos estranhos
 -  3: Falha na abertura do arquivo
 -  4: Falha na alocacao de memoria
 -  5: Numeros invalidos


*/



//Dependencias
#include<iostream>
using std::cin ;        //Entrada
using std::cout;        //Saida
using std::endl;        //Linha


#include<iomanip>
using std::setw;        //Escapamento


#include<string>
using std::string;      //Cadeia de caracteres

#include<cctype>        //Para caracteres
using namespace std;

#include<limits>        //Para numeric_limits

#include<fstream>
using std::ofstream;    //Gravar arquivo
using std::ifstream;    //Ler arquivo

#include "Erro.hpp"

//Outras dependencias
void pause(string text){

    string dummy;
    cin.clear();
    cout << endl << text;
    cin.ignore();
    getline(cin, dummy);
    cout << endl << endl;
}



//Definicao da classe
class Contatos : public Erro{


    private:

        string nome;
        string fone;
        string fone2;
        int    ctt;

        bool isValidFone(string str){

            for(int i = 0; i < str.length(); i++){

                if(!isdigit(str[i]) && str[i] != '-'){

                        return false;
                }
            }
            return true;
        }

        bool isValidFoneQuant(int n){

            if(n != 1 && n != 2){

                return false;
            }
            return true;
        }

    public:

        //Destrutor
        ~Contatos(){}

        //Construtor Padrao
        Contatos(){

            setErro(0); //Nenhum erro

            nome  = "";
            fone  = "";
            fone2 = "";
            ctt   = 0;
        }

        //Construtor alternativo
        Contatos(string name, string tel, string tel2){

            setErro(0); //Nenhum erro

            //Atribuir valores
            setNome(name);
            ctt = 2;
            setFone(tel);
            setFone2a(tel2);
        }

        //Construtor alternativo
        Contatos(string name, string tel){

            setErro(0); //Nenhum erro

            //Atribuir valores
            setNome(name);
            ctt = 1;
            setFone2a(tel);
        }

        //Construtor de copia de dados
        Contatos(Contatos const & other){

            setErro(0); //Nenhum erro

            if(other.ctt == 1){

                //Atribuir valores
                setNome(other.nome);
                setFone(other.fone);
                setFone2a(other.fone2);
            } else if(other.ctt == 2){

                //Atribuir valores
                setNome(other.nome);
                setFone(other.fone);
                setFone2a(other.fone2);
            } else if(other.ctt == 0){

                //Atribuir valores
                setNome(other.nome);
            }
        }


        //-----------------------------------------Metodos para acesso
        /**

         * Metodo para atribuir nome
         * @param nome a ser atribuido

        */
        void setNome(string nome){

            if(nome.empty()){

                setErro(1); //Nome invalido
            } else {

                this->nome = nome;
            }
        }



        /**

         * Metodo para atribuir telefone
         * @param fone a ser atribuido

        */
        void setFone(string fone){

            if(fone.empty()){

                setErro(1); //Fone invalido
            } else {

                if(!this->isValidFone(fone)){

                    setErro(2);
                    return;
                }
                this->ctt  = this->ctt + 1;
                this->fone = fone;
            }
        }

        /**

         * Metodo para atribuir telefone 2 caso queira
         * @param fone a ser atribuido

        */
        void setFone2a(string fone){

            if(fone.empty()){

                setErro(1); //Fone invalido
            } else {

                if(this->ctt == 1){

                    int edit;
                    cout << "\nDeseja adicionar um novo fone(1 - Sim / 2 - Nao): " << endl;
                    cin  >> edit;
                    cin.ignore();

                    if(edit == 1){

                        if(!this->isValidFone(fone)){

                            setErro(2);
                            return;
                        }

                        this->ctt   = this->ctt + 1;
                        this->fone2 = fone;
                        cout << "\nFone 2 adicionado com sucesso!" << endl;

                    } else if(edit == 2){

                        cout << "\nFone 2 nao adicionado!" << endl;
                        return;

                    } else {

                        cout << "\nERROR: Opcao invalida!" << endl;
                        setErro(5);
                        return;
                    }
                } else {

                    cout << "\nERROR: Nao ha dados!" << endl;
                    setErro(1);
                }
            }
        }

        /**

         * Metodo para alterar telefone 2
         * @param fone a ser atribuido

        */
        void setFone2b(string fone){

            if(fone.empty()){

                setErro(1); //Fone invalido
            } else {

                if(this->ctt != 2){

                    cout << "\nERROR: Nao foi possivel alterar segundo fone. Nao existe!" << endl;
                    setErro(1);
                    return;
                } else {

                    string f;

                    cout << "\nDigite o novo fone: " << endl;
                    getline(cin, f);

                    if(isValidFone(f)){

                       fone2 = f;
                    } else {

                        cout << "\nERROR: Fone invalido!" << endl;
                        setErro(2);
                        return;
                    }
                }
            }
        }


        /**

         * Metodo para excluir telefone 2
         * @param fone a ser atribuido

        */
        void setFone2c(){

            if(fone.empty()){

                setErro(1); //Fone invalido
            } else {

                if(this->ctt != 2){

                    cout << "\nERROR: Nao foi possivel excluir segundo fone. Nao existe!" << endl;
                    setErro(1);
                    return;
                } else {

                    this->ctt = this->ctt - 1;
                    this->fone2 = "";
                }
            }
        }

        /**

         * Metodo para atribuir numero de contatos
         * @param numero a ser atribuido

        */
        void setCtt(int n){

            if(!isValidFoneQuant(n)){

                setErro(5); //Fone invalido
            } else {

                this->ctt = n;
            }
        }


        /**

         *  Metodo para obter nome
         * @return nome armazenado

        */
        string getNome(){

            return this->nome;
        }



        /**

         *  Metodo para obter fone
         * @return fone armazenado

        */
        string getFone(){

            return this->fone;
        }

        /**

         *  Metodo para obter fone 2
         * @return fone armazenado

        */
        string getFone2(){

            return this->fone2;
        }


        /**

         *  Metodo para obter quantia de fones
         * @return quantia de fones armazenados

        */
        int getCtt(){

            return this->ctt;
        }


        /**

         * Metodo para obter dados
         * @return dados armazenados

        */
        string toString(){

            if(this->ctt == 1){

                return "{"+getNome()+", "+getFone()+"}";
            } else if(this->ctt == 2){

                return "{"+getNome()+", "+getFone()+", "+getFone2()+"}";
            } else if(this->ctt == 0){

                cout << "\nNao ha numero salvo para " << getNome() << "!" << endl;
                return "{"+getNome()+"}";
            }

            cout << "\nNao ha dados!" << endl;
            setErro(1);
            return "";
        }



        /**

         * Metodo para ler nome

        */
        void readName(){

            //Definir dados
            string str;

            cout << "Nome: ";
            getline(cin, str);

            if(!str.empty()){

                setNome(str);
            } else {

                setErro(1);
            }
        }


        /**

         * Metodo para ler telefone

        */
        void readFone(){

            //Definir dados
            string str;

            cout << "Fone: ";
            getline(cin, str);

            if(!str.empty()){

                if(!isValidFone(str)){

                    setErro(2);
                    return;
                }
                setFone(str);
            } else {

                setErro(1);
            }
        }

        /**

         * Metodo para ler telefone 2

        */
        void readFone2(){

            //Definir dados
            string str;

            cout << "Fone: ";
            getline(cin, str);

            if(!str.empty()){

                if(!isValidFone(str)){

                    setErro(2);
                    return;
                }
                setFone2a(str);
            } else {

                setErro(1);
            }
        }

        /**

         * Metodo para imprimir contatos em arranjos

        */
        void ShowContact(){

             if(!this->hasErro()){

                 cout << this->toString() << endl;
             } else {

                 cout << "Pessoa determinada tem erro " << "(" << this->getErro() << ")" << endl;
             }
         }


         //-----------------------------------------Metodos estaticos -> Nao dependem de objeto instanciado para ser executado


         /**

         * Metodo para gravar dado em arquivo
         * @param nome do arquivo

        */
         static void writeToFile(string filename, int n, Contatos* pessoa){

             //Definir dados
             ofstream file;

             //Operacoes com arquivos
             file.open(filename, ios::out);
             if(!file.is_open()){ cout << "\nERROR: Nao foi possivel abrir arquivo" << endl; return; }

             file << n << endl;

             for(int i = 0; i < n; i++){

                if(pessoa[i].ctt == 1){

                  file << pessoa[i].getCtt()  << endl;
                  file << pessoa[i].getNome() << endl;
                  file << pessoa[i].getFone() << endl;
               } else if(pessoa[i].ctt == 2){

                  file << pessoa[i].getCtt()   << endl;
                  file << pessoa[i].getNome()  << endl;
                  file << pessoa[i].getFone()  << endl;
                  file << pessoa[i].getFone2() << endl;
               } else if(pessoa[i].ctt == 0){

                  cout << "\nPessoa sem numero. Nao foi gravada no arquivo!" << endl;
               }
             }

             file.close();
         }

         /**

         * Metodo para ler contatos de um arquivo
         * @param nome do arquivos

        */
         static Contatos* readFromFile(string filename, Contatos* pessoa) {

            //Definir dados
            ifstream file;
            int n;

            file.open(filename, ios::in);

            if(!file.is_open()){

                cout << "\nERROR: Não foi possível abrir o arquivo" << endl;
                return nullptr;
            }

            file >> n;

            if(n <= 0){

                cout << "\nERROR: Nao foi possivel ler dados do arquivo. Quantia invalida!" << endl;
                return nullptr;
            }

            for(int i = 0; i < n; i++){

               file >> pessoa[i].ctt;
               if(pessoa[i].ctt == 1){

                  file >> pessoa[i].nome;
                  file >> pessoa[i].fone;
               } else if(pessoa[i].ctt == 2){

                  file >> pessoa[i].nome;
                  file >> pessoa[i].fone;
                  file >> pessoa[i].fone2;
               }
            }

            return pessoa;
         }

         static void ShowContacts(Contatos* pessoas, int n){

            if(n <= 0){

                cout << "\nERROR: Nao foi possivel imprimir. Nao ha dados!" << endl;
                return;
            }

            for(int i = 0; i < n; i++){

                cout << pessoas[i].toString() << endl;
            }
         }
};

using ref_Contatos = Contatos*;

#endif // CONTATOS_HPP
