package maquina.estados;

public interface Estado {
    public Estado inserirMoeda(Estado e);
    public Estado puxarAlavanca(Estado e);
    public Estado ejetarMoeda(Estado e);
    public Estado entregarGoma(Estado e);
}