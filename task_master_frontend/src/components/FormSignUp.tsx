import { VStack, useToast } from "native-base";
import { useNavigation } from "@react-navigation/native";
import { useForm, Controller } from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";
import * as yup from "yup";

import { StackNavigation } from "../routes/stack.routes";

import { InputDefault } from "./InputDefault";
import { InputPassword } from "./InputPassword";
import { CheckBox } from "./CheckBox";
import { DividerOR } from "./DividerOR";
import { ButtonPurple } from "./ButtonPurple";
import { ButtonGoogle } from "./ButtonGoogle";
import { CustomAlert } from "./CustomAlert";

type FormDataProps = {
  login: string;
  fone: string;
  password: string;
  confirmPassword: string;
};

const RegexFone =
  /^(?:(?:\+|00)?(55)\s?)?(?:\(?([1-9][0-9])\)?\s?)?(?:((?:9\d|[2-9])\d{3})\-?(\d{4}))$/;

const signUpSchema = yup.object({
  login: yup.string().required("Informe o email!").email("Email inválido!"),
  fone: yup
    .string()
    .required("Informe o Telefone!")
    .matches(RegexFone, { message: "Telefone Inválido" }),
  password: yup.string().required("Informe a senha!"),
  confirmPassword: yup.string().required("Informe a confimação de senha!"),
});

export function FormSignUp() {
  const navigation = useNavigation<StackNavigation>();
  const {
    control,
    handleSubmit,
    formState: { errors },
  } = useForm<FormDataProps>({ resolver: yupResolver(signUpSchema) });

  const toast = useToast();

  function handleSignUp(data: FormDataProps) {
    toast.show({
      placement: "top",
      render: ({ id }) => {
        return (
          <CustomAlert
            toast={toast}
            id={id}
            status="success"
            title="Cadastrado com sucesso!"
            variant="subtle"
            isClosable={true}
          />
        );
      },
    });
    navigation.navigate("SignIn");
  }

  return (
    <VStack space={2}>
      <Controller
        control={control}
        name="login"
        render={({ field: { onChange } }) => (
          <InputDefault
            label="Login"
            placeholder="Cadastre seu email"
            onChangeText={onChange}
            errorMessage={errors.login?.message}
          />
        )}
      />

      <Controller
        control={control}
        name="fone"
        render={({ field: { onChange } }) => (
          <InputDefault
            label="Telefone"
            placeholder="Número de Telefone"
            onChangeText={onChange}
            errorMessage={errors.fone?.message}
          />
        )}
      />

      <Controller
        control={control}
        name="password"
        render={({ field: { onChange } }) => (
          <InputPassword
            label="Senha"
            placeholder="Cadastre sua senha"
            onChangeText={onChange}
            errorMessage={errors.password?.message}
          />
        )}
      />

      <Controller
        control={control}
        name="confirmPassword"
        render={({ field: { onChange } }) => (
          <InputPassword
            label="Confirme sua Senha"
            placeholder="Cadastre sua senha"
            onChangeText={onChange}
            errorMessage={errors.password?.message}
          />
        )}
      />

      <ButtonPurple text="Cadastre-se" onPress={handleSubmit(handleSignUp)} />
    </VStack>
  );
}
