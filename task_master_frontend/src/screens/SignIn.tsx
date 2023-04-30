import { Image, Box, Text } from "native-base";
import { useNavigation } from "@react-navigation/native";

import { FormSignIn } from "../components/FormSignIn";
import { ScreenDefault } from "../components/ScreenDefault";
import { StackNavigation } from "../routes/stack.routes";

export function SignIn() {
  const navigation = useNavigation<StackNavigation>();
  return (
    <ScreenDefault>
      <Image source={require("../assets/logo.png")} alt="Logo" />
      <FormSignIn />

      <Box flexDirection={"row"} alignSelf={"center"} mt={8}>
        <Text fontSize="md">Ainda não possui cadastro?</Text>
        <Text
          fontSize="md"
          ml={2}
          bold
          color={"purple.900"}
          onPress={() => navigation.navigate("SignUp")}
        >
          Cadastre-se
        </Text>
      </Box>
    </ScreenDefault>
  );
}
