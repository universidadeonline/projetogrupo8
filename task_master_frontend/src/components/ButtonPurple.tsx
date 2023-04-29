import { useNavigation } from "@react-navigation/native";
import { Button, IButtonProps } from "native-base";

import { StackNavigation, StackNavigationProps } from "../routes/stack.routes";
import { StackParamList } from "../routes/stack.routes";

interface ButtonPurpleProps extends IButtonProps {
  text: string;
  navigate?: keyof StackParamList;
}

export function ButtonPurple({ text, navigate, ...rest }: ButtonPurpleProps) {
  const navigation = useNavigation<StackNavigation>();
  return (
    <Button
      borderRadius={12}
      backgroundColor={"purple.900"}
      onPress={navigate ? () => navigation.navigate(navigate) : undefined}
      {...rest}
    >
      {text}
    </Button>
  );
}
