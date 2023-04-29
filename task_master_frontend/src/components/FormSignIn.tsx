import { VStack, Box, Text, useToast } from "native-base";
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
  password: string;
};

const signInSchema = yup.object({
  login: yup.string().required("Informe o email!").email("Email inválido!"),
  password: yup.string().required("Informe a senha!"),
});

export function FormSignIn() {
  const navigation = useNavigation<StackNavigation>();
  const {
    control,
    handleSubmit,
    formState: { errors },
  } = useForm<FormDataProps>({ resolver: yupResolver(signInSchema) });

  const toast = useToast();

  function handleSignIn(data: FormDataProps) {
    toast.show({
      placement: "top",
      render: ({ id }) => {
        return (
          <CustomAlert
            toast={toast}
            id={id}
            status="success"
            title="Logado com sucesso!"
            variant="subtle"
            isClosable={true}
          />
        );
      },
    });
    navigation.navigate("Drawer");
  }

  return (
    <VStack space={2}>
      <Controller
        control={control}
        name="login"
        render={({ field: { onChange } }) => (
          <InputDefault
            label="Login"
            placeholder="Insira seu Email"
            onChangeText={onChange}
            errorMessage={errors.login?.message}
          />
        )}
      />

      <Controller
        control={control}
        name="password"
        render={({ field: { onChange } }) => (
          <InputPassword
            label="Senha"
            placeholder="Insira sea Senha"
            onChangeText={onChange}
            errorMessage={errors.password?.message}
          />
        )}
      />

      <CheckBox label="Lembre-se de mim" value={""} mt={2}/>

      <ButtonPurple text="Login" onPress={handleSubmit(handleSignIn)} my={5}/>

      <DividerOR />

      <ButtonGoogle mt={5}/>

     
    </VStack>
  );
}
