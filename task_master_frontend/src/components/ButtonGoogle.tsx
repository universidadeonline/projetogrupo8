import { Button, IButtonProps, Text } from "native-base";
import { AntDesign } from "@expo/vector-icons";

export function ButtonGoogle({ ...rest }: IButtonProps) {
  return (
    <Button
      borderRadius={12}
      backgroundColor={"white"}
      w={100}
      alignSelf={"center"}
      {...rest}
    >
      <Text bold>
        <AntDesign name="google" size={20} color="black" />
        oogle
      </Text>
    </Button>
  );
}
