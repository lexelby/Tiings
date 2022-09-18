package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_50c
   extends TilingType
{
   public TilingTypeNC6_50c(){
      super( "NC6-50c", 6, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 50, 60};
      paramName = new String[]{"Aspect", "Indentation"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 5,4, 0,4,5, 0},
            {1, 0,1, 1,0,1, 1},
            {1, 5,4, 2,4,5, 1},
      };
      info = "a=c=d=e\nC+D=360\nA=B\n2B+C=360\n(E+F=C)";
   }
   
   public void recalcBase(double[] paramValues) {
      double lntotal = 2.0;
      double ln1 = lntotal * getParam(paramValues, 0)/100;
      double ln2 = (lntotal - ln1)/4;
      double ind = ln1 * ( getParam(paramValues, 1)/100 -.5 );
      
      baseTile.setPoint(0,     ind,  0);
      baseTile.setPoint(1, ln1-ind,  0);
      baseTile.setPoint(2, ln1+ind, ln2);
      baseTile.setPoint(3, ln1-ind, ln2*2);
      baseTile.setPoint(4, ln1+ind, ln2*3);
      baseTile.setPoint(5,    -ind, ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[3].getX(0)-tiles[0].getX(0);
      offsets[1] = tiles[3].getY(0)-tiles[0].getY(0);
      offsets[2] = tiles[0].getX(4)-tiles[0].getX(0);
      offsets[3] = tiles[0].getY(4)-tiles[0].getY(0);
   }
}