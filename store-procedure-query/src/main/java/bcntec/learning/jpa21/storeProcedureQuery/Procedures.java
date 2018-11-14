package bcntec.learning.jpa21.storeProcedureQuery;

import javax.persistence.*;

/**
 * @author francisco.philip@gmail.com
 */
@MappedSuperclass
@NamedStoredProcedureQueries( {
        @NamedStoredProcedureQuery(name = "MessageSendProcedure", procedureName = "PROC_SEND_MESSAGE",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "message", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "message_type", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "sender", type = String.class)}),

        @NamedStoredProcedureQuery(name = "MessageSendAndShowProcedure", procedureName = "PROC_SEND_MESSAGE_AND_SHOW",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "message", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "message_type", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "sender", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name="cursor",type = void.class)}


        )}
)
public class Procedures {
}
