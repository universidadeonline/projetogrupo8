import {
  Alert,
  VStack,
  HStack,
  IconButton,
  CloseIcon,
  Text,
  IToastProps,
  IAlertProps,
} from "native-base";

type ToastAlertProps = Pick<IAlertProps, "status" | "variant"> & {
  toast?: {
    show: (props: IToastProps) => any;
    close: (id: any) => void;
    closeAll: () => void;
    isActive: (id: any) => boolean;
  };
  id?: number;
  title: string;
  description?: string;
  isClosable?: boolean;
};

export function CustomAlert({
  toast,
  id,
  status,
  variant,
  title,
  description,
  isClosable,
  ...rest
}: ToastAlertProps) {
  return (
    <Alert
      maxWidth="90%"
      alignSelf="center"
      flexDirection="row"
      status={status ? status : "info"}
      variant={variant}
      {...rest}
    >
      <VStack space={1} flexShrink={1} w="100%">
        <HStack
          flexShrink={1}
          alignItems="center"
          justifyContent="space-between"
        >
          <HStack space={2} flexShrink={1} alignItems="center">
            <Alert.Icon />
            <Text
              fontSize="md"
              fontWeight="medium"
              flexShrink={1}
              color={
                variant === "solid"
                  ? "lightText"
                  : variant !== "outline"
                  ? "darkText"
                  : null
              }
            >
              {title}
            </Text>
          </HStack>
          {isClosable ? (
            <IconButton
              variant="unstyled"
              icon={<CloseIcon size="3" />}
              _icon={{
                color: variant === "solid" ? "lightText" : "darkText",
              }}
              onPress={() => toast.close(id)}
            />
          ) : null}
        </HStack>
        {description && (
          <Text
            px="6"
            color={
              variant === "solid"
                ? "lightText"
                : variant !== "outline"
                ? "darkText"
                : null
            }
          >
            {description}
          </Text>
        )}
      </VStack>
    </Alert>
  );
}
