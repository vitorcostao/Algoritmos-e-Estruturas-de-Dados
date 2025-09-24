/*

    Exemplo de implementacao - v0.0. - 05/12/2024

*/






//------------------------------------------Inclusoes e dependencia
#include<iostream>
#include<iomanip>
#include<fstream>
#include "contatos.hpp"
using namespace std;



//------------------------------------------Metodos

/**

    Metodo_00: Nao faz nada.

*/
void metodo_00(){

    //Nao faz nada
}



/**

 Metodo_01: Testar definicoes da classe.

*/
void metodo_01(){

    //Definir dados
    Contatos pessoa1;
    ref_Contatos pessoa2 = nullptr;
    ref_Contatos pessoa3 = new Contatos();

    //Identificar
    cout << "\nMetodo_01 - v0.0\n" << endl;

    //Encerrar
    pause("Apertar ENTER para continuar!");
}

/**

 * Metodo_02: Testar atribuicoes

*/
void metodo_02(){

    //Definir dados
    Contatos pessoa1;
    ref_Contatos pessoa2 = nullptr;
    ref_Contatos pessoa3 = new Contatos();

    //Identificar
    cout << "\nMetodo_02 - v0.0\n" << endl;

    //Testar atribuicao
    pessoa1.setNome("Pessoa_01");
    pessoa1.setFone("111");
    pessoa3->setNome("Pessoa_03");
    pessoa3->setFone("333");

    cout << "Pessoa 1 - {"<< pessoa1.getNome()  << ", " << pessoa1.getFone()   <<"}" << endl;
    cout << "Pessoa 3 - {"<< pessoa3->getNome() << ", " << pessoa3->getFone() <<"}"  << endl;

    pause("Apertar ENTER para continuar!");
}

/**

 * Metodo_03 - Testar recuperacao dos dados.

*/
void metodo_03(){

    //Definir dados
    Contatos pessoa1;
    ref_Contatos pessoa2 = nullptr;
    ref_Contatos pessoa3 = new Contatos();

    //Identificar
    cout << "\nMetodo_03 - v0.0\n" << endl;

    //Testar atribuicao
    pessoa1.setNome("Pessoa_01");
    pessoa1.setFone("111");
    pessoa3->setNome("Pessoa_03");
    pessoa3->setFone("333");

    cout << "Pessoa 1 - " << pessoa1.toString()  << endl;
    cout << "Pessoa 3 - " << pessoa3->toString() << endl;

    pause("Apertar ENTER para continuar!");
}

/**

 * Metodo_04 - Testar construtor alternativo.

*/
void metodo_04(){

    //Definir dados
    Contatos pessoa1("Pessoa_01", "111");
    ref_Contatos pessoa2 = nullptr;
    ref_Contatos pessoa3 = new Contatos("Pessoa_03", "333");

    //Identificar
    cout << "\nMetodo_04 - v0.0\n" << endl;

    cout << "Pessoa 1 - " << pessoa1.toString() << endl;
    cout << "Pessoa 3 - " << pessoa3->toString() << endl;

    pause("Apertar ENTER para continuar!");
}


/**

 * Metodo_05 - Testar construtor alternativo.

*/
void metodo_05(){

    //Definir dados
    Contatos pessoa1("Pessoa_01", "111");
    ref_Contatos pessoa2 = nullptr;
    ref_Contatos pessoa3 = new Contatos("", "333");

    //Identificar
    cout << "\nMetodo_05 - v0.0\n" << endl;

    cout << "Pessoa 1 - " << pessoa1.toString()  << "(" << pessoa1.getErro()  << ")" << endl;
    cout << "Pessoa 3 - " << pessoa3->toString() << "(" << pessoa3->getErro() << ")" << endl;

    pause("Apertar ENTER para continuar!");
}


/**

 * Metodo_06 - Testar construtor alternativo.

*/
void metodo_06(){

    //Definir dados
    Contatos pessoa1("Pessoa_01", "111");
    ref_Contatos pessoa2 = nullptr;
    ref_Contatos pessoa3 = new Contatos("", "333");

    //Identificar
    cout << "\nMetodo_06 - v0.0\n" << endl;

    if(!pessoa1.hasErro()){

        cout << "Pessoa 1 - " << pessoa1.toString() << endl;
    } else {

        cout << "Pessoa 1 tem erro " << "(" << pessoa1.getErro() << ")" << endl;
    }

    if(!pessoa3->hasErro()){

        cout << "Pessoa 3 - " << pessoa3->toString() << endl;
    } else {

        cout << "Pessoa 3 tem erro " << "(" << pessoa3->getErro() << ")" << endl;
    }

    pause("Apertar ENTER para continuar!");
}


/**

 * Metodo_07 - Testar atribuicoes e tratamento de erro.

*/
void metodo_07(){

    //Definir dados
    Contatos pessoa1("Pessoa_01", "111");
    ref_Contatos pessoa2 = nullptr;
    ref_Contatos pessoa3 = new Contatos("", "333");

    //Identificar
    cout << "\nMetodo_07 - v0.0\n" << endl;

    //Testar atribuicoes
    pessoa2 = &pessoa1;

    if(!pessoa2->hasErro()){

        cout << "Pessoa 1 - " << pessoa2->toString() << endl;
    } else {

        cout << "Pessoa 1 tem erro " << "(" << pessoa2->getErro() << ")" << endl;
    }

    //Vincular a outro objeto
    pessoa2 = pessoa3;

    if(!pessoa2->hasErro()){

        cout << "Pessoa 3 - " << pessoa2->toString() << endl;
    } else {

        cout << "Pessoa 3 tem erro " << "(" << pessoa2->getErro() << ")" << endl;
    }

    pause("Apertar ENTER para continuar!");
}


/**

 * Metodo_08 - Testar construtor de copia.

*/
void metodo_08(){

    //Definir dados
    Contatos pessoa1("Pessoa_01", "111");
    ref_Contatos pessoa2 = nullptr;
    ref_Contatos pessoa3 = new Contatos("", "333");
    ref_Contatos pessoa4 = nullptr;

    //Identificar
    cout << "\nMetodo_08 - v0.0\n" << endl;

    //Testar construtor
    pessoa2 = new Contatos(pessoa1);
    if(pessoa2){

        cout << "Pessoa 2 - " << pessoa2->toString() << endl;
    } else {

        cout << "Pessoa 2 - (" << pessoa2->getErro() << ")" << endl;
    }

    if(pessoa3){

       pessoa2 = new Contatos(*pessoa3);
       if(pessoa2){

         cout << "Pessoa 2 - " << pessoa2->toString() << endl;
       } else {

         cout << "Pessoa 2 tem erro (" << pessoa3->getErro() << ")" << endl;
       }
    }

    if(pessoa4){

       pessoa2 = new Contatos(*pessoa4);
       if(pessoa2){

         cout << "Pessoa 2 - " << pessoa2->toString() << endl;
       } else {

         cout << "Pessoa 2 tem erro (" << pessoa4->getErro() << ")" << endl;
       }
    }


    pause("Apertar ENTER para continuar!");
}


/**

 * Metodo_09 - Testar arranjo de objetos.

*/
void metodo_09(){

    //Definir dados
    Contatos pessoa[3];
    int x = 0;

    //Identificar
    cout << "\nMetodo_09 - v0.0\n" << endl;

    //Testar atribuicoes
    pessoa[0].setNome("Pessoa_1");
    pessoa[0].setFone("111");
    pessoa[0].setCtt(1);

    pessoa[1].setNome("Pessoa_2");
    pessoa[1].setFone("222");
    pessoa[1].setCtt(1);

    pessoa[2].setNome("Pessoa_3");
    pessoa[2].setFone("333");
    pessoa[2].setCtt(1);

    for(x = 0; x < 3; x++){

        cout << x + 1 << ": " << pessoa[x].toString() << endl;
    }


    pause("Apertar ENTER para continuar!");
}


/**

 * Metodo_10 - Testar arranjo de objetos por referencia.

*/
void metodo_10(){

    //Definir dados
    Contatos *pessoa[3];
    int x = 0;

    //Identificar
    cout << "\nMetodo_10 - v0.0\n" << endl;

    //Testar atribuicoes
    pessoa[0] = new Contatos("Pessoa_1", "111");

    pessoa[1] = new Contatos("Pessoa_2", "222");

    pessoa[2] = new Contatos("Pessoa_3", "333");


    for(x = 0; x < 3; x++){

        cout << x + 1 << ": " << pessoa[x]->toString() << endl;
    }


    pause("Apertar ENTER para continuar!");
}


/**

 * Metodo_11 - Testar leitura de dados.

*/
void metodo_11(){

    //Definir dados
    Contatos pessoa[3];
    int x = 0;

    //Identificar
    cout << "\nMetodo_11 - v0.0\n" << endl;

    //Testar atribuicoes
    pessoa[0].readName();
    pessoa[0].readFone();
    pessoa[0].setCtt(1);

    pessoa[1].readName();
    pessoa[1].readFone();
    pessoa[1].readFone2();
    pessoa[1].setCtt(2);

    pessoa[2].readName();
    pessoa[2].readFone();
    pessoa[2].setCtt(1);

    cout << endl;

    for(int i = 0; i < 3; i++){

        pessoa[i].ShowContact();
    }


    pause("Apertar ENTER para continuar!");
}


/**

 * Metodo_12 - Testar gravacao de dados em arquivo.

*/
void metodo_12(){

    //Definir dados
    Contatos pessoas[2];

    //Identificar
    cout << "\nMetodo_12 - v0.0\n" << endl;

    //Testar atribuicoes
    pessoas[0].readName();
    pessoas[0].readFone();
    pessoas[0].readFone2();
    pessoas[0].setCtt(2);

    pessoas[1].readName();
    pessoas[1].readFone();
    pessoas[1].setCtt(1);

    cout << endl;

    for(int i = 0; i < 2; i++){

        if(pessoas[i].hasErro()){

            cout << "\nNao foi possivel gravar dados em arquivo!" << endl;
            cout << "Pessoa " << i + 1 << " tem erro! " << "(" << pessoas[i].getErro() << ")" << endl;
            cout << endl;
            return;
        }
    }

    Contatos::writeToFile("PESSOAS.TXT", 2, pessoas);

    pause("Apertar ENTER para continuar!");
}


/**

 * Metodo_13 - Testar leitura de dados em arquivo.

*/
void metodo_13(){

    //Definir dados
    Contatos pessoa[2];
    ofstream file;

    //Identificar
    cout << "\nMetodo_13 - v0.0\n" << endl;

    //Testar funcao
    Contatos::readFromFile("PESSOAS.TXT", pessoa);
    Contatos::ShowContacts(pessoa, 2);



    pause("Apertar ENTER para continuar!");
}


/**

 * Metodo_14 - Testar segundo telefone nos dados.

*/
void metodo_14(){

    //Definir dados
    Contatos pessoa[2];
    ofstream file;

    //Identificar
    cout << "\nMetodo_14 - v0.0\n" << endl;

    //Testar funcao
    Contatos::readFromFile("PESSOAS.TXT", pessoa);
    Contatos::ShowContacts(pessoa, 2);

    pause("Apertar ENTER para continuar!");
}


/**

 * Metodo_15 - Testar quantia de telefones.

*/
void metodo_15(){

    //Definir dados
    Contatos pessoa[2];
    ofstream file;

    //Identificar
    cout << "\nMetodo_15 - v0.0\n" << endl;

    //Testar funcao
    Contatos::readFromFile("PESSOAS.TXT", pessoa);
    Contatos::ShowContacts(pessoa, 2);
    cout << "\nQuantia de fones P1: " << pessoa[0].getCtt() << endl;
    cout << "\nQuantia de fones P2: " << pessoa[1].getCtt() << endl;

    pause("Apertar ENTER para continuar!");
}

/**

 * Metodo_16 - Testar adicionar fone.

*/
void metodo_16(){

    //Definir dados
    Contatos pessoa[2];
    ofstream file;

    //Identificar
    cout << "\nMetodo_15 - v0.0\n" << endl;

    //Testar funcao
    Contatos::readFromFile("PESSOAS.TXT", pessoa);
    Contatos::ShowContacts(pessoa, 2);

    //Adicionar ou nao
    pessoa[1].setFone2a("9982-1241");
    cout << "Pessoa 2: " << pessoa[1].toString() << endl;


    pause("Apertar ENTER para continuar!");
}


/**

 * Metodo_17 - Testar editar fone.

*/
void metodo_17(){

    //Definir dados
    Contatos pessoa[2];
    ofstream file;

    //Identificar
    cout << "\nMetodo_17 - v0.0\n" << endl;

    //Testar funcao
    Contatos::readFromFile("PESSOAS.TXT", pessoa);
    Contatos::ShowContacts(pessoa, 2);

    //Editar
    pessoa[0].setFone2b("9982-1241");
    cout << "Pessoa 1: " << pessoa[0].toString() << endl;
    pessoa[1].setFone2b("9982-1241");
    cout << "Pessoa 2: " << pessoa[1].toString() << endl;


    pause("Apertar ENTER para continuar!");
}


/**

 * Metodo_18 - Testar excluir fone.

*/
void metodo_18(){

    //Definir dados
    Contatos pessoa[2];
    ofstream file;

    //Identificar
    cout << "\nMetodo_18 - v0.0\n" << endl;

    //Testar funcao
    Contatos::readFromFile("PESSOAS.TXT", pessoa);
    Contatos::ShowContacts(pessoa, 2);

    cout << endl;

    //Editar
    pessoa[0].setFone2c();
    cout << "Pessoa 1: " << pessoa[0].toString() << endl;
    pessoa[1].setFone2c();
    cout << "Pessoa 2: " << pessoa[1].toString() << endl;


    pause("Apertar ENTER para continuar!");
}

//Funcao principal
int main(int argc, char** argv){

    //Definir dados
    int x = 0;

    //Repeticao
    do {

        //Identificar
        cout << "EXEMPLO - PROGRAMA - v0.0\n" << endl;

        //Mostrar opcoes
        cout << "Opcoes                                                " << endl;
        cout << "0  - Parar                                            " << endl;
        cout << "1  - Testar definicao de contatos (objetos)           " << endl;
        cout << "2  - Testar atribuicao de contatos (objetos)          " << endl;
        cout << "3  - Testar recuperando de contatos (objetos)         " << endl;
        cout << "4  - Testar construtor A de contatos (objetos)        " << endl;
        cout << "5  - Testar erros atribuidos contatos (objetos)       " << endl;
        cout << "6  - Testar se existe erros no contato (objetos)      " << endl;
        cout << "7  - Testar a atribuicao e tratar erros (objetos)     " << endl;
        cout << "8  - Testar a contrutor de copia e erros (objetos)    " << endl;
        cout << "9  - Testar arrays com contatos e metodos (objetos)   " << endl;
        cout << "10 - Testar arrays* com contatos e metodos (objetos)  " << endl;
        cout << "11 - Testar leitura para os dados (objetos)           " << endl;
        cout << "12 - Testar saida nos arquivos.txt (objetos)          " << endl;
        cout << "13 - Testar entrada nos arquivo.txt (objetos)         " << endl;
        cout << "14 - Testar outro fone para a pessoa (objetos)        " << endl;
        cout << "15 - Testar retorno do tanto de fones (objetos)       " << endl;
        cout << "16 - Testar desejo para adicionar fone (objetos)      " << endl;
        cout << "17 - Testar edicao se existir fone dois (objetos)     " << endl;
        cout << "18 - Testar exclusao se fone dois existe (objetos)     " << endl;

        //Ler do teclado
        cout << endl << "Entrar com uma opcao: ";
        cin  >> x;
        cin.ignore();


        //Escolher acao
        switch(x){

            case 0:
                metodo_00();
                break;

            case 1:
                metodo_01();
                break;

            case 2:
                metodo_02();
                break;

            case 3:
                metodo_03();
                break;

            case 4:
                metodo_04();
                break;

            case 5:
                metodo_05();
                break;

            case 6:
                metodo_06();
                break;

            case 7:
                metodo_07();
                break;

            case 8:
                metodo_08();
                break;

            case 9:
                metodo_09();
                break;

            case 10:
                metodo_10();
                break;

            case 11:
                metodo_11();
                break;

            case 12:
                metodo_12();
                break;

            case 13:
                metodo_13();
                break;

            case 14:
                metodo_14();
                break;

            case 15:
                metodo_15();
                break;

            case 16:
                metodo_16();
                break;

            case 17:
                metodo_17();
                break;

            case 18:
                metodo_18();
                break;

            default:
                cout << endl << "ERRO: Valor invalido!" << endl;
                break;
        }
    } while(x != 0);

    //Encerrar
    pause("Apertar ENTER para terminar!");
    return 0;
}
