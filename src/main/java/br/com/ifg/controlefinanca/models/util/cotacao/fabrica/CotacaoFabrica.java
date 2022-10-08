package br.com.ifg.controlefinanca.models.util.cotacao.fabrica;

import br.com.ifg.controlefinanca.models.util.cotacao.adpter.Cotacao;
import br.com.ifg.controlefinanca.models.util.cotacao.adpter.CotacaoDolar;
import br.com.ifg.controlefinanca.models.util.cotacao.adpter.CotacaoEuro;
import br.com.ifg.controlefinanca.models.util.enuns.TipoMoeda;

public class CotacaoFabrica {
    /** Factory Method */
    public static Cotacao getCotacao(TipoMoeda tipoMoeda) {
        switch (tipoMoeda){
            case DOLAR:  {return new CotacaoDolar();}
            case EURO:  {return new CotacaoEuro();}
            default: { throw new IllegalArgumentException("Opção de tipo de mensagem inválida!");}
        }
    }
}
