package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_55
   extends TilingType
{
   public TilingTypeNC6_55(){
      super( "NC6-55", 6, SymmetryType.p2 );

      paramMin = new int[]{  0,  0,  0};
      paramMax = new int[]{100,100,100};
      paramDef = new int[]{ 50, 70, 20};
      paramName = new String[]{"Aspect", "Indentation", "Y"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {1, 0,0, 0,0,0, 0},
            {1, 0,5, 0,5,0, 0},
            {0, 1,2, 0,3,4, 1},
            {0, 3,2, 2,2,3, 1},
      };
      info = "a=d\nb=f\nc=e\nA+F=360\nC+E=A\n(A+B+D=360)";
   }
   
   public void recalcBase(double[] paramValues) {
      double size = 1.5;
      double w = size * getParam(paramValues, 0)/100;
      double h = size - w;

      double ind =  w * (getParam(paramValues, 1)/100-.5);
      double h2 = h * getParam(paramValues, 2)/100;

      baseTile.setPoint(0,  -ind,   0);
      baseTile.setPoint(1,   ind,  -h2);
      baseTile.setPoint(2, w+ind,   0);
      baseTile.setPoint(3, w-ind,   h-h2);
      baseTile.setPoint(4,  -ind,   h);
      baseTile.setPoint(5,   ind,   h-h2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(2)-tiles[3].getX(5);
      offsets[1] = tiles[0].getY(2)-tiles[3].getY(5);
      offsets[2] = tiles[2].getX(3)-tiles[0].getX(1);
      offsets[3] = tiles[2].getY(3)-tiles[0].getY(1);
   }
}