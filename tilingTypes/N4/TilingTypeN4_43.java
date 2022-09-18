package tilingTypes.N4;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN4_43
   extends TilingType
{
   public TilingTypeN4_43(){
      super( "N4-43", 4, SymmetryType.pgg );

      paramMin = new int[]{  0};
      paramMax = new int[]{100};
      paramDef = new int[]{ 50};
      paramName = new String[]{ "Length" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,3, 0,0,3, 1},
            {0, 2,3, 0,3,2, 0},
            {1, 0,3, 2,0,3, 1},
            
            {1, 1,0, 0,1,2, 0},
            {0, 0,3, 4,0,3, 1},
            {0, 2,3, 5,3,2, 1},
            {1, 0,3, 6,0,3, 0},
      };
      info = "c=2b+d\nA=90\n2B+C=180\n(C+2D=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln1 = 1 * getParam( paramValues,0)/100;
      double ln2 = 1 - ln1;
      double f = 1.5 / (ln1+ln1+ln2);
      ln1 *= f;
      ln2 *= f;
      
      double side = Math.sqrt( 4*(ln1+ln2)*(ln1+ln2)-ln1*ln1 );
      double ln3 = side * ln1/(ln1+ln2);
      double dy = (side-ln3)/2;
      double dx = ln1 * ln2/(ln1+ln2)/2;
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,ln1,  0);
      baseTile.setPoint(2, dx,ln3+dy);
      baseTile.setPoint(3,  0,ln3);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(2)-tiles[0].getX(1);
      offsets[1] = tiles[7].getY(2)-tiles[0].getY(1);
      offsets[2] = tiles[4].getX(2)-tiles[2].getX(1);
      offsets[3] = tiles[4].getY(2)-tiles[2].getY(1);
   }

}
